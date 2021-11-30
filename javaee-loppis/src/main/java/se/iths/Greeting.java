package se.iths;

import javax.inject.Named;

@Named
public class Greeting {

    public String getMessage() {
        return "Hello JU20 from JSF!";
    }
}
