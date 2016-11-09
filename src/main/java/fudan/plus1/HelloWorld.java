package fudan.plus1;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("/hello/{username}")
public class HelloWorld {
    @GET
    @Produces("text/plain")
    public String responseHello(@PathParam("username") String username) {
        return "Hello " + username;
    }
}