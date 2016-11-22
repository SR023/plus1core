package fudan.plus1.Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */
public interface AbstractCounter {
    // setter
    int setCounterInfo
    (String administrator, String counterName, double value, double step, String unit);

    // when looking for some counter
    boolean isThisCounter(String CounterId);

    // getters
    String getCounterName();
    double getValue();
    double getStep();
    String getUnit();
    String getAdministrator();
    String getCounterId();

    // count
    int count();
    int count(boolean isMinus);
}
