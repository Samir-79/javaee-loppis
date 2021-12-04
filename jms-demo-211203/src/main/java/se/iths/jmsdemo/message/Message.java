package se.iths.jmsdemo.message;

import java.io.Serializable;

public class Message  implements Serializable {

    private String message;
    public Message(String message) {
        this.message= message;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
