package Implementations;
/**
 * Created by billlai on 08/Oct/2016.
 */
import java.util.ArrayList;
import java.util.List;
import Interfaces.*;
import Kits.Finals;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

public class Plus1System implements AbstractSystem {
    private List<Counter> counters = new ArrayList<>();
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

    @Override
    public int createUser(String username, String password) {
        return UserProcessor.getInstance().createUser(username, password);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return UserProcessor.getInstance().isUsernameAvailable(username);
    }

    @Override
    public int signIn(String username, String password) {
        int signInResult = UserProcessor.getInstance().signIn(username, password);
        if (signInResult == Finals.SIGN_IN_SECCEEDED) {
            this.username = username;
        }
        return signInResult;
    }

    @Override
    public int createSingleUserCounter(String counterName, double value, double step, String unit) {
        Counter counter = SingleUserCounterFactory.getInstance().
                createSingleUserCounter(counterName, value, step, unit);
        return addCounter(counter);
    }

    @Override
    public int createMultiUserCounter
            (String counterId, String counterPassword,
             String counterName, double value, double step, String unit) {
        Counter counter =  MultiUserCounterFactory.getInstance().createMultiUserCounter
                (counterId, counterPassword, counterName, value, step, unit);
        addCounter(counter);
        return 0;
    }

    @Override
    public int addMultiUserCounter(String counterId, String counterPassword) {
        Counter counter = MultiUserCounterFactory.getInstance().
                addMultiUserCounter(counterId, counterPassword);
        addCounter(counter);
        return 0;
    }

    @Override
    public boolean isCounterIdLegal(String counterId) {
        return MultiUserCounterFactory.getInstance().isCounterIdLegal(counterId);
    }

    @Override
    public boolean isCounterIdAvailable(String counterId) {
        return MultiUserCounterFactory.getInstance().isCounterIdAvailable(counterId);
    }

    @Override
    public boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword) {
        return MultiUserCounterFactory.getInstance().
                isAbleToAddMultiUserCounter(counterId, counterPassword);
    }

    @Override
    public int count(String counterId) {
        return findCounter(counterId).count();
    }

    @Override
    public int count(String counterId, boolean isMinus) {
        return findCounter(counterId).count(isMinus);
    }

    @Override
    public int deleteCounter(String counterId) {
        Counter counter = findCounter(counterId);
        counters.remove(counter);
        return 0;
    }

    @Override
    public int backup() {
        return BackupManager.getInstance().backup();
    }

    @Override
    public int changeCounterInfo
            (String counterId, String newCounterName, double value, double step, String unit) {
        Counter counter = findCounter(counterId);
        counter.setCounterInfo(newCounterName, value, step, unit);
        return 0;
    }

    @Override
    public List<Counter> getCounters() {
        return counters;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isCounterCreatedByMe(String counterId) {
        return findCounter(counterId).getCounterId().equals(counterId);
    }
}
