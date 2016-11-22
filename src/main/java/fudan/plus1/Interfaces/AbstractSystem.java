package fudan.plus1.Interfaces;
import java.util.List;

/**
 * Created by billlai on 08/Oct/2016.
 */
public interface AbstractSystem {
    // user
     int createUser(String username, String password);
     boolean isUsernameAvailable(String username);
     int signIn(String username, String password);

    // create counter
    int createCounter(
            String administrator,
            String counterName,
            double value,
            double step,
            String unit);

    int addMultiUserCounter(String username, String counterId);

    // count
    int count(String counterId);
    int count(String counterId, boolean isMinus);

    // delete
    int deleteCounter(String counterId);

    // change counter info
    int changeCounterInfo(
            String administrator,
            String counterId,
            String counterName,
            double value,
            double step,
            String unit);

    // getter of Counters
    List<AbstractCounter> getCounters(String username);
}
