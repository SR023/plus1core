package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.CounterId;
import fudan.plus1.JsonTypes.Result;
import fudan.plus1.JsonTypes.UserExistence;
import fudan.plus1.Kits.Finals;

import org.codehaus.jettison.json.JSONObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/services")
public class ServicesHandler {
    @Path("/userexistence/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserExistence getUserExistence(@PathParam("username") String username) {
        boolean isUserNameAvailable = Plus1System.getInstance().isUsernameAvailable(username);
        String existence = "" + (isUserNameAvailable ? "yes" : "no");
        UserExistence userExistence = new UserExistence(username, existence);
        return userExistence;
    }

    @Path("/verification/{username}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Result getVerification(@PathParam("username") String username, @PathParam("password") String password) {
        if (username == null || password == null) {
            return new Result(Finals.INFO_MISSING);
        } else {
            return new Result(Plus1System.getInstance().signIn(username, password));
        }
    }

    @Path("/countercreation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
            return new CounterId(Finals.INFO_MISSING);
        } else {
            double valueInDouble;
            double stepInDouble;
            try {
                valueInDouble = Double.parseDouble(value);
                stepInDouble = Double.parseDouble(step);
            } catch (NumberFormatException e) {
                return new CounterId(Finals.PARSING_ERROR);
            }
            return Plus1System.getInstance().
                    createCounter(administrator, counterName, valueInDouble, stepInDouble, unit);
        }
    }

    @Path("/usercreation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
