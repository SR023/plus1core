package fudan.plus1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by billlai on 05/十一月/2016.
 */
@Path("/person/{name}")
public class GetPerson {
    @GET
    @Produces("application/json")
    public People getPerson(@PathParam("name") String name) {
        return new People(name, "noPassword");
    }
}
