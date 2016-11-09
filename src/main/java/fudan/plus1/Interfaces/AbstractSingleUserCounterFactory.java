package Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */

public interface AbstractSingleUserCounterFactory {
    Counter createSingleUserCounter(String counterName, double value, double step, String unit);
}
