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
//        connectionFactory.setHost("35.230.88.45");
        connectionFactory.setHost("localhost");
        connection = connectionFactory.newConnection();

        channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}