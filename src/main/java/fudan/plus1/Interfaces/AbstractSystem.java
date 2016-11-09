package Interfaces;
import java.util.List;
import org.junit.*;

/**
 * Created by billlai on 08/Oct/2016.
 */
public interface AbstractSystem {
    // user
     int createUser(String username, String password);
     boolean isUsernameAvailable(String username);
     int signIn(String username, String password);

    // create counter
        // single user
     int createSingleUserCounter(String counterName, double value, double step, String unit);

        // multi user
     int createMultiUserCounter(String counterId, String counterPassword, String counterName,
                                double value, double step, String unit);
    boolean isCounterIdAvailable(String counterId);
    boolean isCounterIdLegal(String counterId);
    boolean isAbleToAddMultiUserCounter(String counterId, String counterPassword);
    int addMultiUserCounter(String counterId, String counterPassword);

    // count
    int count(String counterId);
    int count(String counterId, boolean isMinus);

    // delete
    int deleteCounter(String counterId);

    // backup
    int backup();

    // change counter info
    int changeCounterInfo(String counterId, String newCounterName, double value, double step, String unit);

    // getter of Counters
    List<Counter> getCounters();

    // gettor of username
    String getUsername();

    // others
    boolean isCounterCreatedByMe(String counterId);
}
