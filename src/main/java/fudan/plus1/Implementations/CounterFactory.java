package fudan.plus1.Implementations;
import fudan.plus1.Interfaces.AbstractCounterFactory;
import fudan.plus1.Interfaces.AbstractCounter;
import fudan.plus1.Kits.Finals;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

/**
 * Created by billlai on 08/Oct/2016.
 */
class CounterFactory implements AbstractCounterFactory {
    private final Random random = new Random(new Date().getTime());
    private static CounterFactory ourInstance = new CounterFactory();
    private Map<String, AbstractCounter> counters;

    static CounterFactory getInstance() {
        return ourInstance;
    }

    private CounterFactory() {
        counters = new HashMap<String, AbstractCounter>();
    }

    public String createCounter (
            String administrator,
            String counterName,
            double value,
            double step,
            String unit) {

        String counterId = gernerateCounterId(administrator);

        AbstractCounter counter = new Counter(counterId);
        counter.setCounterInfo(administrator, counterName, value, step, unit);
        return counterId;
    }
    private String gernerateCounterId(String creator) {
        String id = null;
        long time = new Date().getTime();
        long rand = random.nextLong();
        String s = creator + " " + rand;
        String signature = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes(),0,s.length());
            signature = new BigInteger(1, md5.digest()).toString(16);
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return signature == null ? s + time : signature + time;
    }

    public AbstractCounter findCounter(String counterId) throws NullPointerException {
        AbstractCounter counter = counters.get(counterId);
        if (counter == null) {
            throw new NullPointerException();
        } else {
            return counter;
        }
    }
}
