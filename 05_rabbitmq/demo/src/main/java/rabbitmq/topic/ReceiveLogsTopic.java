package rabbitmq.topic;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ReceiveLogsTopic {

	private static final String EXCHANGE_NAME = "topic_logs";
    private static final boolean DURABLE_EXCHANGE = true;
    private static final boolean DURABLE_QUEUE = false;
    private static final boolean EXCLUSIVE = true;
    private static final boolean AUTO_DELETE = true;
    private static final Map<String, Object> ARGUMENTS = null;
    
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.2.46");
        factory.setUsername("admin");
        factory.setPassword("123456123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        if (!exchangeDeclared(channel, EXCHANGE_NAME)) {
        	channel = connection.createChannel();
        	channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, DURABLE_EXCHANGE);
        } else {
        	System.out.println("Exchange's already declared before");
        }
        
        String queueName = Arrays.toString(argv);
        
        if (!queueDeclared(channel, queueName)) {
        	channel = connection.createChannel();
        	channel.queueDeclare(queueName, DURABLE_QUEUE, EXCLUSIVE, AUTO_DELETE, ARGUMENTS);
        } else {
        	System.out.println("Queue's already declared before");
        }
        
        
        for (String bindingKey : argv) {
            channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
        }

        System.out.println(" [*] Waiting for messages, binding keys: "  + Arrays.toString(argv) + ". To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }

	private static boolean exchangeDeclared(Channel channel, String exchangeName) {
		try {
            channel.exchangeDeclarePassive(exchangeName);
        } catch (IOException ioe) {
            return false;
        }
        return true;
	}

	private static boolean queueDeclared(Channel channel, String queueName) {
		try {
            channel.queueDeclarePassive(queueName);
        } catch (IOException ioe) {
            return false;
        }
        return true;
	}
}