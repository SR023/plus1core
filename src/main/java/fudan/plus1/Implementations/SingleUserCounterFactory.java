package Implementations;
import Interfaces.AbstractSingleUserCounterFactory;
import Interfaces.Counter;
import java.util.Date;
import java.util.Random;

/**
 * Created by billlai on 08/Oct/2016.
 */
class SingleUserCounterFactory implements AbstractSingleUserCounterFactory {
    private final Random random = new Random(new Date().getTime());
    private static SingleUserCounterFactory ourInstance = new SingleUserCounterFactory();

    static SingleUserCounterFactory getInstance() {
        return ourInstance;
    }

    private SingleUserCounterFactory() {
    }

    public Counter createSingleUserCounter
            (String counterName, double value, double step, String unit) {
        Date date = new Date();;
        String creator = Plus1System.getInstance().getUsername();
        String counterId = creator + ":" + date.getTime() + ":" + random.nextLong();
        Counter counter = new SingleUserCounter(counterId, creator);
        counter.setCounterInfo(counterName, value, step, unit);
        return counter;
    }
}
