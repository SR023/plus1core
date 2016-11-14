package fudan.plus1.Implementations; /**
 * Created by billlai on 08/Oct/2016.
 */
import fudan.plus1.Interfaces.Counter;
class MultiUserCounter implements Counter {
    private final String counterId;
    private final String creator;

    MultiUserCounter(String counterId, String creator) {
        this.counterId = counterId;
        this.creator = creator;
    }

    public int setCounterInfo(String counterName, double value, double step, String unit) {
        // TODO
        return 0;
    }

    public int count(boolean isMinus) {
        // TODO
        return 0;
    }
    public int count() {
        return count(false);
    }

    public boolean isSingleUserMode() {
        return false;
    }

    public String getCounterName() {
        // TODO
        return null;
    }
    public double getValue() {
        // TODO
        return 0;
    }
    public double getStep() {
        // TODO
        return 0;
    }
    public String getUnit() {
        // TODO
        return null;
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
        return creator.equals(username);
    }
}
