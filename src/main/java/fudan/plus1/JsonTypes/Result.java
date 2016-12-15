package fudan.plus1.JsonTypes;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by billlai on 23/十一月/2016.
 */
@XmlRootElement
public class Result {
    public int result = 0;
    public Result() { }
    public Result(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
