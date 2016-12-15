package fudan.plus1.JsonTypes;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by billlai on 22/十一月/2016.
 */
@XmlRootElement
public class UserExistence implements Serializable{
    public String username;
    public String available;

    public UserExistence() {}

    public UserExistence(String username, String available) {
        this.username = username;
        this.available = available;
    }

    public String getUsername() {
        return username;
    }

    public String getAvailable() {
        return available;
    }
}
