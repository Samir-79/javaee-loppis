package com.company;

public class MessageSender {

    MessageService service;

    public String sendMessage(String message){

        return service.sendMessage(message);
    }

    public MessageSender(MessageService service){
        this.service=service;
    }
}
