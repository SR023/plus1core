package fudan.plus1.Implementations;

import fudan.plus1.Interfaces.AbstractCounter;
import fudan.plus1.Interfaces.AbstractUser;
import fudan.plus1.Kits.Finals;

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

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public List<AbstractCounter> getCounters() {
        return counters;
    }

    public int addMultiUserCounter(String counterId) {
        AbstractCounter counter;
        try {
            counter = CounterFactory.getInstance().findCounter(counterId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return Finals.COUNTER_NOT_EXIST;
        }
        counters.add(counter);
        return 0;
    }

    public int deleteCounter(String counterId) {
        AbstractCounter toDelete = null;
        for (AbstractCounter counter : counters) {
            if (counter.getCounterId().equals(counterId)) {
                toDelete = counter;
                break;
            }
        }
        if (toDelete != null) {
            counters.remove(toDelete);
            return 0;
        } else {
            return Finals.CANNOT_FIND_COUNTER;
        }
    }
}
