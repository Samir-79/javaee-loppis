package se.iths.jmsdemo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.jmsdemo.message.Message;

@Component
public class Sender {


    JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

        System.out.println("Sending message...");
        Message message = new Message("heeeej!");
         jmsTemplate.convertAndSend("JU19_QUEUE", message);
        System.out.println("Message sent!");
    }

}
