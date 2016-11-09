package Implementations;
/**
 * Created by billlai on 08/Oct/2016.
 */
import Interfaces.Counter;
class SingleUserCounter implements Counter{
    private final String counterId;
    private final String creator;

    private String counterName;
    private double value;
    private double step;
    private String unit;

    SingleUserCounter (String counterId, String creator) {
        this.counterId = counterId;
        this.creator = creator;
    }

    @Override
    public int setCounterInfo
            (String counterName, double value, double step, String unit) {
        this.counterName = counterName;
        this.value = value;
        this.step = step;
        this.unit = unit;
        return 0;
    }

    @Override
    public int count(boolean isMinus) {
        if (isMinus) {
            value -= step;
        } else {
            value += step;
        }
        return 0;
    }
    @Override
    public int count() {
        return count(false);
    }

    @Override
    public boolean isSingleUserMode() {
        return true;
    }

    @Override
    public String getCounterName() {
        return counterName;
    }
    @Override
    public double getValue() {
        return value;
    }
    @Override
    public double getStep() {
        return step;
    }
    @Override
    public String getUnit() {
        return unit;
    }
    @Override
    public String getCreator() {
        return creator;
    }
    @Override
    public String getCounterId() {
        return counterId;
    }

    @Override
    public boolean isThisCounter(String counterId) {
        return this.counterId.equals(counterId);
    }

    @Override
    public boolean isCreatedBy(String username) {
        return this.creator.equals(username);
    }
}
