package rabbitmq.direct;

import java.util.Map;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

	private static final String EXCHANGE_NAME = "Direct";
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
	    try (Connection connection = factory.newConnection();
	         Channel channel = connection.createChannel()) {
	        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

	        String routingKey = argv[0];
	        String message = argv[1];

	        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
	        System.out.println(" [x] Sent '" + message + "'");
	    }
	  }
	}