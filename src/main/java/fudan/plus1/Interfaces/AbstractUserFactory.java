package fudan.plus1.Interfaces;

/**
 * Created by billlai on 08/Oct/2016.
 */

public interface AbstractUserFactory {
    int createUser(String username, String password);

    boolean isUsernameAvailable(String username);

    int signIn(String username, String password);

    AbstractUser findUser(String username);
}