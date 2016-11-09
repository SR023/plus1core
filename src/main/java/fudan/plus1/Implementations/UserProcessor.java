package Implementations;

import Interfaces.AbstractUserProcessor;
import Kits.*;
/**
 * Created by billlai on 08/Oct/2016.
 */
class UserProcessor implements AbstractUserProcessor {
    private static UserProcessor ourInstance = new UserProcessor();

    static UserProcessor getInstance() {
        return ourInstance;
    }

    private UserProcessor() {
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        // TODO
        return Finals.USERNAME_AVAILABLE == Finals.USERNAME_AVAILABLE;
    }

    @Override
    public int signIn(String username, String password) {
        // TODO
        return Finals.SIGN_IN_SECCEEDED;
    }

    @Override
    public int createUser(String username, String password) {
        // TODO
        return Finals.SIGN_UP_SECCEEDED;
    }
}
