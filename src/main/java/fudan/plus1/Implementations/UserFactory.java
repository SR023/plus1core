package fudan.plus1.Implementations;

import fudan.plus1.Interfaces.AbstractUser;
import fudan.plus1.Interfaces.AbstractUserFactory;
import fudan.plus1.Kits.*;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by billlai on 08/Oct/2016.
 */
class UserFactory implements AbstractUserFactory {
    private static UserFactory ourInstance = new UserFactory();
    private Map<String, AbstractUser> users;

    static UserFactory getInstance() {
        return ourInstance;
    }
    private UserFactory() {
        users = new HashMap<String, AbstractUser>();
    }

    
    public boolean isUsernameAvailable(String username) {
        return !users.containsKey(username);
    }

    
    public int signIn(String username, String password) {
        if (!users.containsKey(username)) {
            return Finals.USER_NOT_EXIST;
        } else {
            return users.get(username).isPasswordCorrect(password) ? 0 : Finals.WRONG_PASSWORD;
        }
    }

    
    public int createUser(String username, String password) {
        if (users.containsKey(username)) {
            return Finals.USERNAME_UNAVAILABLE;
        }
        User user = new User(username, password);
        users.put(username, user);
        return 0;
    }

    @Nullable
    public AbstractUser findUser(String username) {
        return users.get(username);
    }
}