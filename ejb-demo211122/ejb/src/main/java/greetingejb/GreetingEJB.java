package greetingejb;

import javax.ejb.Stateless;

@Stateless
public class GreetingEJB {

    public String getGreeting(String name) {
        return "Hej "+ name+ ", vänliga hälsningar från en EJB.";
    }

}
