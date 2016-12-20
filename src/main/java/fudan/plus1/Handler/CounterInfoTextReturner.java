package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by billlai on 20/十二月/2016.
 */
@Path("/info/{counterId}")
public class CounterInfoTextReturner {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String counterInfo(@PathParam("counterId") String id) {
        return Plus1System.getInstance().getCounter(id).toString();
    }
}
