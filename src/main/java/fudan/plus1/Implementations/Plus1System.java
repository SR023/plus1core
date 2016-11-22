package fudan.plus1.Implementations;

import java.util.List;
import fudan.plus1.Interfaces.*;
import org.jetbrains.annotations.Nullable;

public class Plus1System implements AbstractSystem {
    private static Plus1System ourInstance = new Plus1System();
    public static Plus1System getInstance() {
        return ourInstance;
    }
    private Plus1System() {
    }

    @Nullable
    private AbstractCounter findCounter(String counterId) {
        // TODO
        return null;
    }

    
    public int createUser(String username, String password) {
        return UserFactory.getInstance().createUser(username, password);
    }

    
    public boolean isUsernameAvailable(String username) {
        return UserFactory.getInstance().isUsernameAvailable(username);
    }

    
    public int signIn(String username, String password) {
        int signInResult = UserFactory.getInstance().signIn(username, password);
        return signInResult;
    }

    
    public int createCounter(String administrator, String counterName, double value, double step, String unit) {
        AbstractCounter counter = CounterFactory.getInstance().
                createCounter(administrator, counterName, value, step, unit);
        return 0; // TODO
    }

    
    public int addMultiUserCounter(String username, String counterId) {
        // TODO
        return 0;
    }

    
    public int count(String counterId) {
        return findCounter(counterId).count();
    }

    
    public int count(String counterId, boolean isMinus) {
        return findCounter(counterId).count(isMinus);
    }

    
    public int deleteCounter(String counterId) {
        // TODO
        return 0;
    }

    
    public int changeCounterInfo (
            String administrator,
            String counterId,
            String counterName,
            double value,
            double step,
            String unit) {
        AbstractCounter abstractCounter = findCounter(counterId);
        abstractCounter.setCounterInfo(administrator, counterName, value, step, unit);
        return 0;
    }

    
    public List<AbstractCounter> getCounters(String username) {
        return null; // TODO
    }


    
    public boolean isCounterCreatedByMe(String counterId) {
        return findCounter(counterId).getCounterId().equals(counterId);
    }
}
