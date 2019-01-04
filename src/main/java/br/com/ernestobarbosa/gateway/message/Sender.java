package br.com.ernestobarbosa.gateway.message;

import br.com.ernestobarbosa.gateway.config.Connector;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender extends Connector {

    public Sender(String queueName) throws IOException, TimeoutException {
        super(queueName);
    }

    public void sendMessage(String object) throws IOException {
        channel.basicPublish("",queueName, null, object.getBytes());
    }
}
