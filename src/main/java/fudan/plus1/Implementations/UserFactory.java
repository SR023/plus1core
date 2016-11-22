package fudan.plus1.Implementations;

import fudan.plus1.Interfaces.AbstractUser;
import fudan.plus1.Interfaces.AbstractUserFactory;
import fudan.plus1.Kits.*;
/**
 * Created by billlai on 08/Oct/2016.
 */
class UserFactory implements AbstractUserFactory {
    private static UserFactory ourInstance = new UserFactory();

    static UserFactory getInstance() {
        return ourInstance;
    }

    private UserFactory() {
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

    public AbstractUser findUser(String username) {
        return null; // TODO
    }
}
