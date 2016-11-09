package fudan.plus1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by billlai on 05/十一月/2016.
 */
@Path("/people")
public class GetPeople {
    @GET
    @Produces("application/json")
    public List<People> getPeople() {
        List<People> list = new ArrayList<People>();
        for (int i = 0; i < 6; i++) {
            list.add(new People("name" + i, "pw" + i));
        }
        return list;
    }
}
