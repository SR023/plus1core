package fudan.plus1.Implementations;
/**
 * Created by billlai on 08/Oct/2016.
 */
import fudan.plus1.Interfaces.AbstractCounter;
class Counter implements AbstractCounter {
    private String counterId;
    private String administrator;

    private String counterName;
    private double value;
    private double step;
    private String unit;

    Counter() {}
    Counter(String counterId) {
        this.counterId = counterId;
    }

    
    public int setCounterInfo
            (String administrator, String counterName, double value, double step, String unit) {
        this.administrator = administrator;
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
    
    public String getAdministrator() {
        return administrator;
    }
    
    public String getCounterId() {
        return counterId;
    }
}
