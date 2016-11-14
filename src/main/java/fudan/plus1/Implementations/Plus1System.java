package fudan.plus1.Implementations;

import java.util.ArrayList;
import java.util.List;
import fudan.plus1.Interfaces.*;
import fudan.plus1.Kits.*;
import org.jetbrains.annotations.Nullable;

public class Plus1System implements AbstractSystem {
    private List<Counter> counters = new ArrayList<Counter>();
    private String username;

    private static Plus1System ourInstance = new Plus1System();
    public static Plus1System getInstance() {
        return ourInstance;
    }
    private Plus1System() {
    }

    private int addCounter(Counter counter) {
        counters.add(counter);
        return 0;
    }
    @Nullable
    private Counter findCounter(String counterId) {
        for (Counter counter : counters) {
            if (counter.isThisCounter(counterId)) {
                return counter;
            }
        }
        return null;
    }

    
    public int createUser(String username, String password) {
        return UserProcessor.getInstance().createUser(username, password);
    }

    
    public boolean isUsernameAvailable(String username) {
        return UserProcessor.getInstance().isUsernameAvailable(username);
    }

    
    public int signIn(String username, String password) {
        int signInResult = UserProcessor.getInstance().signIn(username, password);
        if (signInResult == Finals.SIGN_IN_SUCCEEDED) {
            this.username = username;
        }
        return signInResult;
    }

    
    public int createSingleUserCounter(String counterName, double value, double step, String unit) {
        Counter counter = SingleUserCounterFactory.getInstance().
                createSingleUserCounter(counterName, value, step, unit);
        return addCounter(counter);
    }

    
    public int createMultiUserCounter
            (String counterId, String counterPassword,
             String counterName, double value, double step, String unit) {
        Counter counter =  MultiUserCounterFactory.getInstance().createMultiUserCounter
                (counterId, counterPassword, counterName, value, step, unit);
        addCounter(counter);
        return 0;
    }

    
    public int addMultiUserCounter(String counterId, String counterPassword) {
        Counter counter = MultiUserCounterFactory.getInstance().
                addMultiUserCounter(counterId, counterPassword);
        addCounter(counter);
        return 0;
    }

    
    public boolean isCounterIdLegal(String counterId) {
        return MultiUserCounterFactory.getInstance().isCounterIdLegal(counterId);
    }

    
    public boolean isCounterIdAvailable(String counterId) {
        return MultiUserCounterFactory.getInstance().isCounterIdAvailable(counterId);
    }

    
    public boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword) {
        return MultiUserCounterFactory.getInstance().
                isAbleToAddMultiUserCounter(counterId, counterPassword);
    }

    
    public int count(String counterId) {
        return findCounter(counterId).count();
    }

    
    public int count(String counterId, boolean isMinus) {
        return findCounter(counterId).count(isMinus);
    }

    
    public int deleteCounter(String counterId) {
        Counter counter = findCounter(counterId);
        counters.remove(counter);
        return 0;
    }

    
    public int backup() {
        return BackupManager.getInstance().backup();
    }

    
    public int changeCounterInfo
            (String counterId, String newCounterName, double value, double step, String unit) {
        Counter counter = findCounter(counterId);
        counter.setCounterInfo(newCounterName, value, step, unit);
        return 0;
    }

    
    public List<Counter> getCounters() {
        return counters;
    }

    
    public String getUsername() {
        return username;
    }

    
    public boolean isCounterCreatedByMe(String counterId) {
        return findCounter(counterId).getCounterId().equals(counterId);
    }
}
