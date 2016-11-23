package fudan.plus1.Implementations;

import java.util.ArrayList;
import java.util.List;
import fudan.plus1.Interfaces.*;
import fudan.plus1.Kits.Finals;
import org.jetbrains.annotations.Nullable;

public class Plus1System implements AbstractSystem {
    private static Plus1System ourInstance = new Plus1System();
    public static Plus1System getInstance() {
        return ourInstance;
    }
    private Plus1System() {
    }

    public int createUser(String username, String password) {
        return UserFactory.getInstance().createUser(username, password);
    }

    
    public boolean isUsernameAvailable(String username) {
        return UserFactory.getInstance().isUsernameAvailable(username);
    }

    
    public int signIn(String username, String password) {
        return UserFactory.getInstance().signIn(username, password);
    }

    
    public int createCounter(String administrator, String counterName, double value, double step, String unit) {
        String id = CounterFactory.getInstance().createCounter(administrator, counterName, value, step, unit);
        return addMultiUserCounter(administrator, id);
    }

    
    public int addMultiUserCounter(String username, String counterId) {
        AbstractUser user = UserFactory.getInstance().findUser(username);
        if (user == null) {
            return Finals.USER_NOT_EXIST;
        } else {
            return user.addMultiUserCounter(counterId);
        }
    }

    
    public int count(String counterId) {
        return count(counterId, false);
    }

    
    public int count(String counterId, boolean isMinus) {
        try {
            AbstractCounter counter = CounterFactory.getInstance().findCounter(counterId);
            counter.count(isMinus);
            return 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return Finals.COUNTER_NOT_EXIST;
        }
    }

    
    public int deleteCounter(String username, String counterId) {
        AbstractUser user = UserFactory.getInstance().findUser(username);
        if (user != null) {
            return user.deleteCounter(counterId);
        } else {
            return Finals.USER_NOT_EXIST;
        }
    }

    
    public int changeCounterInfo (
            String administrator,
            String counterId,
            String counterName,
            double value,
            double step,
            String unit) {
        AbstractCounter counter;
        try {
            counter = CounterFactory.getInstance().findCounter(counterId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return Finals.COUNTER_NOT_EXIST;
        }
        if (counter.getAdministrator().equals(administrator)) {
            counter.setCounterInfo(administrator, counterName, value, step, unit);
            return 0;
        } else {
            return Finals.COUNTER_ADMINISTRATOR_VERIFICATION_ERROR;
        }
    }

    
    public List<AbstractCounter> getCounters(String username) {
        AbstractUser user = UserFactory.getInstance().findUser(username);
        if (user == null) {
            return new ArrayList<AbstractCounter>();
        } else {
            return user.getCounters();
        }
    }

    public AbstractCounter getCounter(String counterId) {
        AbstractCounter counter = null;
        try {
            counter = CounterFactory.getInstance().findCounter(counterId);
        } catch (NullPointerException e) {
            return new Counter();
        }
        return counter;
    }
}
