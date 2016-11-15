package fudan.plus1.Implementations;
import fudan.plus1.Interfaces.AbstractCounterFactory;
import fudan.plus1.Interfaces.Counter;
import java.util.Date;
import java.util.Random;

/**
 * Created by billlai on 08/Oct/2016.
 */
class CounterFactory implements AbstractCounterFactory {
    private final Random random = new Random(new Date().getTime());
    private static CounterFactory ourInstance = new CounterFactory();

    static CounterFactory getInstance() {
        return ourInstance;
    }

    private CounterFactory() {
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
