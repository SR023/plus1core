package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.Result;
import fudan.plus1.JsonTypes.UserExistence;
import fudan.plus1.Kits.Finals;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/services")
public class ServicesHandler {
    @Path("/userexistence/{username}")
    @GET
    @Produces("application/json")
    public UserExistence getUserExistence(@PathParam("username") String username) {
        boolean isUserNameAvailable = Plus1System.getInstance().isUsernameAvailable(username);
        String existence = "" + (isUserNameAvailable ? "yes" : "no");
        return new UserExistence(username, existence);
    }

    @Path("/verification")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Result getVerification(JSONObject json) {
        String username = null;
        String password = null;
        username = json.optString("username");
        password = json.optString("password");
        if (username == null || password == null) {
            return new Result(Finals.INFO_MISSING);
        } else {
            return new Result(Plus1System.getInstance().signIn(username, password));
        }
    }

    @Path("/countercreation")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Result postCounterCreation(JSONObject json) {
        String administrator = null;
        String counterName = null;
        String value = null;
        String step = null;
        String unit = null;

        administrator = json.optString("administrator");
        counterName = json.optString("counterName");
        value = json.optString("value");
        step = json.optString("step");
        unit = json.optString("unit");

        if (null == administrator || null == counterName || null == value || null == step || null == unit) {
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
                    createCounter(administrator, counterName, valueInDouble, stepInDouble, unit));
        }
    }

    @Path("/usercreation")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Result postUserCreation(JSONObject json) {
        String username = null;
        String password = null;
        username = json.optString("username");
        password = json.optString("password");
        if (username == null || password == null) {
            return new Result(Finals.INFO_MISSING);
        } else {
            return new Result(Plus1System.getInstance().createUser(username, password));
        }
    }
}
