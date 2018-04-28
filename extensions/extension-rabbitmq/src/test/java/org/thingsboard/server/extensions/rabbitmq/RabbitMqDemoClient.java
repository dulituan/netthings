/**
 *
 */
package org.thingsboard.server.extensions.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author Andrew Shvayka
 */
public class RabbitMqDemoClient {

    private static final String HOST = "localhost";
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";
    private static final String QUEUE_NAME = "queue";


    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages.");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
