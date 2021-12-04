package se.iths.jmsdemo.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.jmsdemo.message.Message;

import javax.jms.ObjectMessage;

@Component
public class Receiver {

    @JmsListener(destination = "JU19_QUEUE")
    public void listen(@Payload Message message) {
        System.out.println("I got a message");
        System.out.println(message);
    }
}
