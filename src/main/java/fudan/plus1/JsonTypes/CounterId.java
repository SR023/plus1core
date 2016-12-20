package fudan.plus1.JsonTypes;

import fudan.plus1.Kits.Finals;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by billlai on 20/十二月/2016.
 */
@XmlRootElement
public class CounterId extends Result{
    public String counterId = "";
    public CounterId() {}
    public CounterId(int result, String counterId) {
        super(result);
        this.counterId = counterId;
    }
    public CounterId(int result) {
        super(result);
    }
}
