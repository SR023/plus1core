package Implementations; /**
 * Created by billlai on 08/Oct/2016.
 */
import Interfaces.Counter;
class MultiUserCounter implements Counter {
    private final String counterId;
    private final String creator;

    MultiUserCounter(String counterId, String creator) {
        this.counterId = counterId;
        this.creator = creator;
    }

    @Override
    public int setCounterInfo(String counterName, double value, double step, String unit) {
        // TODO
        return 0;
    }

    @Override
    public int count(boolean isMinus) {
        // TODO
        return 0;
    }
    @Override
    public int count() {
        return count(false);
    }

    @Override
    public boolean isSingleUserMode() {
        return false;
    }

    @Override
    public String getCounterName() {
        // TODO
        return null;
    }
    @Override
    public double getValue() {
        // TODO
        return 0;
    }
    @Override
    public double getStep() {
        // TODO
        return 0;
    }
    @Override
    public String getUnit() {
        // TODO
        return null;
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
        return creator.equals(username);
    }
}
