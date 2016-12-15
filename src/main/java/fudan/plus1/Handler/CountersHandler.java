package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Implementations.Counter;
import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/users/{username}/counters")
public class CountersHandler {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Counter> getCountersByUsername(@PathParam("username") String username) {
        // verification...
        List<Counter> list = Plus1System.getInstance().getCounters(username);
        return list;
    }
}
