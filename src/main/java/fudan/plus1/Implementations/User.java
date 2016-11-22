package fudan.plus1.Implementations;

import fudan.plus1.Interfaces.AbstractCounter;
import fudan.plus1.Interfaces.AbstractUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by billlai on 21/十一月/2016.
 */
public class User implements AbstractUser {
    private String username;
    private String password;
    private List<AbstractCounter> counters;

    User() { }
    User(String username, String password) {
        this.username = username;
        this.password = password;
        counters = new ArrayList<AbstractCounter>();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<AbstractCounter> getCounters() {
        return counters;
    }
}
