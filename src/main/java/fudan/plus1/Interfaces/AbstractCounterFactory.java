package fudan.plus1.Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */

public interface AbstractCounterFactory {
    Counter createCounter(String administrator,
                          String counterName,
                          double value,
                          double step,
                          String unit);
}
