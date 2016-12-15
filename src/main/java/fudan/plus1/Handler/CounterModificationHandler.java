package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.Result;
import fudan.plus1.Kits.Finals;
import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/users/{username}/{counterId}")
public class CounterModificationHandler {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Result postCounter(
            JSONObject json, @PathParam("username") String username, @PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().addMultiUserCounter(username, id));
    }

//    @Path("/counterdeletion/{username}/{counterId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Result deleteCounter(
            @PathParam("username") String username, @PathParam("counterId") String id) {
        return new Result(Plus1System.getInstance().deleteCounter(username, id));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result putCounter(
            JSONObject json, @PathParam("username") String username, @PathParam("counterId") String id) {
        String administrator;
        String counterName;
        String value;
        String step;
        String unit;

        administrator = json.optString("administrator");
        counterName = json.optString("counterName");
        value = json.optString("value");
        step = json.optString("step");
        unit = json.optString("unit");

        if (administrator.equals("") || counterName.equals("") || value.equals("") || step.equals("") || unit.equals("")) {
            return new Result(Finals.INFO_MISSING);
        } else {
            double valueInDouble;
            double stepInDouble;

            try {
                valueInDouble = Double.parseDouble(value);
                stepInDouble = Double.parseDouble(step);
            } catch (NumberFormatException e) {
                return new Result(Finals.PARSING_ERROR);
            }

            return new Result(Plus1System.getInstance().
                    changeCounterInfo(administrator, id, counterName, valueInDouble, stepInDouble, unit));

        }
    }
}
