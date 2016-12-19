package fudan.plus1.Implementations;

import fudan.plus1.Kits.*;
import fudan.plus1.Persistence.*;

import org.hibernate.HibernateException;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * Created by billlai on 08/Oct/2016.
 */
public class UserFactory {
    private static UserFactory ourInstance = new UserFactory();
    private Map<String, User> users;

    public static UserFactory getInstance() {
        return ourInstance;
    }
    private UserFactory()  {
    	users = new HashMap<String, User>();
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
        PersistenceUser.getInstance().addUser(user);
        return 0;
    }
    
    public int createExistUser(String username, String password) {
        if (users.containsKey(username)) {
            return Finals.USERNAME_UNAVAILABLE;
        }
        User user = new User(username, password);
        users.put(username, user);
        return 0;
    }
    
    public User findUser(String username) {
        return users.get(username);
    }
}
