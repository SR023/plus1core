package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Interfaces.AbstractCounter;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/users/{username}/counters")
public class CountersHandler {
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public List<AbstractCounter> getCountersByUsername(JSONObject json, @PathParam("username") String username) {
        // verification...
        return Plus1System.getInstance().getCounters(username);
    }
}
