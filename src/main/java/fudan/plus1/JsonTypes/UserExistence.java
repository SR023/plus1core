package fudan.plus1.JsonTypes;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by billlai on 22/十一月/2016.
 */
@XmlRootElement
public class UserExistence {
    private String username;
    private String existence;
    public UserExistence() {}
    public UserExistence(String username, String existence) {
        this.username = username;
        this.existence = existence;
    }

    public String getUsername() {
        return username;
    }

    public String getExistence() {
        return existence;
    }
}
