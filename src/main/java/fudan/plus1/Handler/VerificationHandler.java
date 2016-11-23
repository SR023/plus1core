package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.Result;
import fudan.plus1.Kits.Finals;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("/services/verification")
public class VerificationHandler {
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
}
