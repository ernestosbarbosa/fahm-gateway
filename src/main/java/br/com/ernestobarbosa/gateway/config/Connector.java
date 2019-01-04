package br.com.ernestobarbosa.gateway.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class Connector {
    protected Channel channel;
    protected Connection connection;
    protected String queueName;

    public Connector(String queueName) throws IOException,TimeoutException {
        this.queueName=queueName;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // Hostname of your rabbitmq server
        connectionFactory.setHost("localhost");
        // getting a connection
        connection = connectionFactory.newConnection();

        /*this will create a new channel, using an internally allocated channel number or we can say it will simply declare a queue for this channel. If queue does not exist.*/
        channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}