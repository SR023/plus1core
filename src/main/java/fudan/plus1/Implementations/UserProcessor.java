package fudan.plus1.Implementations;

import fudan.plus1.Interfaces.AbstractUserProcessor;
import fudan.plus1.Kits.*;
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

    
    public boolean isUsernameAvailable(String username) {
        // TODO
        return Finals.USERNAME_AVAILABLE == Finals.USERNAME_AVAILABLE;
    }

    
    public int signIn(String username, String password) {
        // TODO
        return Finals.SIGN_IN_SUCCEEDED;
    }

    
    public int createUser(String username, String password) {
        // TODO
        return Finals.SIGN_UP_SUCCEEDED;
    }
}
