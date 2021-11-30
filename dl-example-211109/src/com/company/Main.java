package com.company;

import java.security.Provider;

public class Main {

    public static void main(String[] args) {

        //DEPENDENCY INJECTION
        MessageService service= new SMSService();
        MessageSender messageSender= new MessageSender(service);
        //
        System.out.println(messageSender.sendMessage("Hej JU20!"));

    }
}
