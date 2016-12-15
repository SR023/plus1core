package fudan.plus1.Implementations;
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
public class CounterFactory {
    private final Random random = new Random(new Date().getTime());
    private static CounterFactory ourInstance = new CounterFactory();
    private Map<String, Counter> counters;

    public static CounterFactory getInstance() {
        return ourInstance;
    }

    private CounterFactory() {
        counters = new HashMap<String, Counter>();
    }

    private void addCounter(String counterId, Counter counter) {
        counters.put(counterId, counter);
    }

    public String createCounter (
            String administrator,
            String counterName,
            double value,
            double step,
            String unit) {

        String counterId = gernerateCounterId(administrator);

        Counter counter = new Counter(counterId);
        counter.setCounterInfo(administrator, counterName, value, step, unit);
        addCounter(counterId, counter);

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

    public Counter findCounter(String counterId) throws NullPointerException {
        Counter counter = counters.get(counterId);
        if (counter == null) {
            throw new NullPointerException();
        } else {
            return counter;
        }
    }
}
