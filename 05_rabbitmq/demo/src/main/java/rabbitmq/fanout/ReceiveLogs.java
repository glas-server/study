package rabbitmq.fanout;
import java.util.Map;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ReceiveLogs {
	private static final String EXCHANGE_NAME = "Fanout";
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

		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
		String queueName = argv[0];
		
		channel.queueDeclare(queueName, DURABLE_QUEUE, EXCLUSIVE, AUTO_DELETE, ARGUMENTS);
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		System.out.println(" [*] Waiting for messages from queue: "+queueName+". To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
		};
		channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
		});
	}
}
