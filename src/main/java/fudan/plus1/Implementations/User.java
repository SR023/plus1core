package fudan.plus1.Implementations;

import fudan.plus1.Kits.Finals;

import java.util.ArrayList;
import java.util.List;
import fudan.plus1.Persistence.*;

/**
 * Created by billlai on 21/十一月/2016.
 */
public class User {
    private String username;
    private String password;
    private List<Counter> counters;


    User() { }
    User(String username, String password) {
        this.username = username;
        this.password = password;
        counters = new ArrayList<Counter>();
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

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public int addMultiUserCounter(String counterId) {
        Counter counter;
        try {
            counter = CounterFactory.getInstance().findCounter(counterId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return Finals.COUNTER_NOT_EXIST;
        }
        for (Counter counterIn : counters) {
            if (counter.getCounterId().equals(counterIn.getCounterId())) {
                return Finals.DUPLICATED_COUNTER;
            }
        }
        counters.add(counter);
        
        return 0;
    }


    public int deleteCounter(String counterId) {
        Counter toDelete = null;
        for (Counter counter : counters) {
            if (counter.getCounterId().equals(counterId)) {
                toDelete = counter;
                break;
            }
        }
        if (toDelete != null) {
            counters.remove(toDelete);

            return 0;
        } else {
            return Finals.COUNTER_NOT_EXIST;
        }
    }
}
