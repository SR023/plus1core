package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Implementations.Counter;
import fudan.plus1.JsonTypes.Result;
import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/counters/{counterId}")
public class CounterHandler {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Counter getCounterById(@PathParam("counterId") String id) {
        return Plus1System.getInstance().getCounter(id);
    }

    @Path("/increase")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Result postIncrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id));
    }

    @Path("/decrease")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Result postDecrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id, true));
    }

}
