package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Implementations.Counter;
import org.codehaus.jettison.json.JSONObject;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/users/{username}/counters")
public class CountersHandler {
    @GET
    @JSONP
    @Produces({MediaType.APPLICATION_JSON, "application/javascript"})
    public List<Counter> getCountersByUsername(@PathParam("username") String username) {
        // verification...
        List<Counter> list = Plus1System.getInstance().getCounters(username);
        return list;
    }
}
