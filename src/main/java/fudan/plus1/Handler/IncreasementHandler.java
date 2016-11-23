package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.Result;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/services/increasement/{counterId}")
public class IncreasementHandler {
    @POST
    @Produces("application/json")
    public Result postIncresement(@PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().count(id));
    }
}
