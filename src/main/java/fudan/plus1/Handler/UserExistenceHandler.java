package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.UserExistence;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by billlai on 22/十一月/2016.
 */
@Path("/services/userexistence/{username}")
public class UserExistenceHandler {
    @GET
    @Produces("application/json")
    public UserExistence getUserExistence(@PathParam("username") String username) {
        boolean isUserNameAvailable = Plus1System.getInstance().isUsernameAvailable(username);
        String existence = "" + (isUserNameAvailable ? "yes" : "no");
        return new UserExistence(username, existence);
    }
}
