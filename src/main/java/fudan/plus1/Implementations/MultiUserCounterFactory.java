package Implementations;
import Interfaces.AbstractMultiUserCounterFactory;
import Interfaces.Counter;

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

    @Override
    public boolean isCounterIdAvailable(String counterId) {
        // TODO
        return false;
    }

    @Override
    public boolean isCounterIdLegal(String counterId) {
        return counterId.matches("[a-zA-Z0-9]+[_]*[a-zA-Z0-9]*");
    }

    @Override
    public boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword) {
        // TODO
        return false;
    }

    @Override
    public Counter createMultiUserCounter
            (String counterId, String counterPassword,
             String counterName, double value, double step, String unit) {
        // TODO
        return null;
    }

    @Override
    public Counter addMultiUserCounter(String counterId, String counterPassword) {
        // TODO
        return null;
    }

    @Override
    public int deleteCounter(String counterId) {
        // TODO
        return 0;
    }
}
