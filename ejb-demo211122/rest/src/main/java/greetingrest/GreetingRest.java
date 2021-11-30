package greetingrest;

import greetingejb.GreetingEJB;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("message")
public class GreetingRest {

    @EJB
    private GreetingEJB greetingEJB;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@QueryParam("name") String name) {
        return  greetingEJB.getGreeting(name);

    }

}
