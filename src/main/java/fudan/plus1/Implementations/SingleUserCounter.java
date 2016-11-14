package fudan.plus1.Implementations;
/**
 * Created by billlai on 08/Oct/2016.
 */
import fudan.plus1.Interfaces.Counter;
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

    
    public int setCounterInfo
            (String counterName, double value, double step, String unit) {
        this.counterName = counterName;
        this.value = value;
        this.step = step;
        this.unit = unit;
        return 0;
    }

    
    public int count(boolean isMinus) {
        if (isMinus) {
            value -= step;
        } else {
            value += step;
        }
        return 0;
    }
    
    public int count() {
        return count(false);
    }

    
    public boolean isSingleUserMode() {
        return true;
    }

    
    public String getCounterName() {
        return counterName;
    }
    
    public double getValue() {
        return value;
    }
    
    public double getStep() {
        return step;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public String getCounterId() {
        return counterId;
    }

    
    public boolean isThisCounter(String counterId) {
        return this.counterId.equals(counterId);
    }

    
    public boolean isCreatedBy(String username) {
        return this.creator.equals(username);
    }
}
