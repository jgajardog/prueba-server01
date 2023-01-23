package org.acme;

import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    private static AtomicLong counter = new AtomicLong(0);

    @ConfigProperty(name = "app.hostname")
    private String hostname;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        StringBuilder msg = new StringBuilder();
        msg.append("{ \"server\":\"").append(hostname).append("\"").append(", \"counter\":").append(counter.incrementAndGet()).append("}");
        return msg.toString();
    }
}
