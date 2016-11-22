package fudan.plus1.Interfaces;

import java.util.List;

/**
 * Created by billlai on 21/十一月/2016.
 */
public interface AbstractUser {
    List<AbstractCounter> getCounters();

    boolean isPasswordCorrect(String password);

    void setPassword(String password);

    String getUsername();

    int addMultiUserCounter(String counterId);
}
