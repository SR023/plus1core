package Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */
public interface Counter {
    // setter
    int setCounterInfo
    (String counterName, double value, double step, String unit);

    // when looking for some counter
    boolean isThisCounter(String CounterId);

    // getters
    String getCounterName();
    double getValue();
    double getStep();
    String getUnit();
    String getCreator();
    String getCounterId();

    // count
    int count();
    int count(boolean isMinus);

    // others
    boolean isSingleUserMode();
    boolean isCreatedBy(String username);
}
