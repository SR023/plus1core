package fudan.plus1.Implementations;
import fudan.plus1.Interfaces.AbstractMultiUserCounterFactory;
import fudan.plus1.Interfaces.Counter;

/**
 * Created by billlai on 08/Oct/2016.
 */
class MultiUserCounterFactory implements AbstractMultiUserCounterFactory {
    private static MultiUserCounterFactory ourInstance = new MultiUserCounterFactory();

    static MultiUserCounterFactory getInstance() {
        return ourInstance;
    }

    private MultiUserCounterFactory() {
    }

    
    public boolean isCounterIdAvailable(String counterId) {
        // TODO
        return false;
    }

    
    public boolean isCounterIdLegal(String counterId) {
        return counterId.matches("[a-zA-Z0-9]+[_]*[a-zA-Z0-9]*");
    }

    
    public boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword) {
        // TODO
        return false;
    }

    
    public Counter createMultiUserCounter
            (String counterId, String counterPassword,
             String counterName, double value, double step, String unit) {
        // TODO
        return null;
    }

    
    public Counter addMultiUserCounter(String counterId, String counterPassword) {
        // TODO
        return null;
    }

    
    public int deleteCounter(String counterId) {
        // TODO
        return 0;
    }
}
