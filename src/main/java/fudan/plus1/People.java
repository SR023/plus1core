package fudan.plus1;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by billlai on 05/十一月/2016.
 */
@XmlRootElement
public class People {
    private String username;
    private String password;
    public People(){

    }

    public People(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
