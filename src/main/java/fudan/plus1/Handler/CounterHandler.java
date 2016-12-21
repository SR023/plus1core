package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.Implementations.Counter;
import fudan.plus1.JsonTypes.Result;
import org.codehaus.jettison.json.JSONObject;
import org.glassfish.jersey.server.JSONP;

import javax.print.attribute.standard.Media;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/counters/{counterId}")
public class CounterHandler {
    @GET
    @JSONP
    @Produces({MediaType.APPLICATION_JSON, "application/javascript"})
    public Counter getCounterById(@PathParam("counterId") String id) {
        return Plus1System.getInstance().getCounter(id);
    }

    @Path("/increase")
    @POST
    @JSONP
    @Produces({MediaType.APPLICATION_JSON, "application/javascript"})
    public Result postIncrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id));
    }

    @Path("/decrease")
    @POST
    @JSONP
    @Produces({MediaType.APPLICATION_JSON, "application/javascript"})
    public Result postDecrease(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id, true));
    }

}
