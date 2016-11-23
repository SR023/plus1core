package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Interfaces.AbstractCounter;
import fudan.plus1.JsonTypes.Result;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/counters/{counterId}")
public class CounterHandler {
    @GET
    @Produces("application/json")
    public AbstractCounter getCounterById(@PathParam("counterId") String id) {
        return Plus1System.getInstance().getCounter(id);
    }

    @Path("/increase")
    @POST
    @Produces("application/json")
    public Result postIncrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id));
    }

    @Path("/decrease")
    @POST
    @Produces("application/json")
    public Result postDecrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id, true));
    }
}
