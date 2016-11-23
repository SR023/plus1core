package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Interfaces.AbstractCounter;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/counters/{counterId}")
public class GettingCounterHandler {
    @GET
    @Produces("application/json")
    public AbstractCounter getCounterById(@PathParam("counterId") String id) {
        return Plus1System.getInstance().getCounter(id);
    }
}
