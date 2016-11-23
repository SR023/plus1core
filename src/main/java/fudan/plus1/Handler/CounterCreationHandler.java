package fudan.plus1.Handler;

import fudan.plus1.Implementations.Plus1System;
import fudan.plus1.JsonTypes.Result;
import fudan.plus1.Kits.Finals;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by billlai on 23/十一月/2016.
 */
@Path("services/countercreation")
public class CounterCreationHandler {
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
}
