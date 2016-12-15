/*
package fudan.plus1.Test;

import fudan.plus1.Implementations.CounterFactory;
import fudan.plus1.Implementations.Plus1System;

import static org.junit.Assert.*;

import fudan.plus1.Implementations.UserFactory;
import fudan.plus1.Kits.Finals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import fudan.plus1.Interfaces.*;

*/
/**
 * Created by billlai on 09/Oct/2016.
 *//*

public class Plus1SystemTest {
    private String username = "LaiWenxing";
    private Plus1System system;
    private AbstractUserFactory userFactory;
    private AbstractCounterFactory counterFactory;
    private final double DELTA = 0.00001;
    @Before
    public void setUp() {
        system = Plus1System.getInstance();
        userFactory = UserFactory.getInstance();
        counterFactory = CounterFactory.getInstance();
        registration();
    }

    void registration() {
        system.createUser("username", "password");
        assertNotNull(userFactory.findUser("username"));
        assertEquals(system.createUser("username", "pass"), Finals.USERNAME_UNAVAILABLE);
        assertEquals(system.signIn("username", "password"), 0);
    }

    @Test
    public void verification() {
        assertEquals(system.signIn("user", "pass"), Finals.USER_NOT_EXIST);
        assertEquals(system.signIn("username", "pass"), Finals.WRONG_PASSWORD);
        assertEquals(system.signIn("", ""), Finals.USER_NOT_EXIST);
        assertEquals(system.signIn("username", ""), Finals.WRONG_PASSWORD);
    }

    @Test
    public void userExistence() {
        assertEquals(system.isUsernameAvailable("username"), false);
    }

    @Test
    public void counterTest() {
        assertEquals(system.createCounter("username", "counterName", 100.0,
                100.0, "unit"), 0);
        List<AbstractCounter> counters = system.getCounters("username");
        assertEquals(counters.size(), 1);
        assertEquals(counters.get(0), system.getCounter(counters.get(0).getCounterId()));
        assertEquals(
                system.createCounter("username", "noName", 0, 0, ""),
                0);
        assertEquals(system.getCounters("username").size(), 2);
        assertEquals(
                system.changeCounterInfo("username",
                        system.getCounters("username").get(0).getCounterId(),
                        "name", 1, 1, "unit"),
                0);

        assertEquals(system.deleteCounter(
                "username", system.getCounters("username").get(1).getCounterId()),
                0);
        assertEquals(system.getCounters("username").size(), 1);

        assertEquals(system.getCounters("user").size(), 0);
        assertNull(system.getCounter("noId").getCounterId());

        assertEquals(
                system.changeCounterInfo
                        ("username", "noId", "", 0, 1, ""),
                Finals.COUNTER_NOT_EXIST);
        assertEquals(
                system.changeCounterInfo
                        ("user", system.getCounters("username").get(0).getCounterId(),
                                "", 0, 1, ""),
                Finals.COUNTER_ADMINISTRATOR_VERIFICATION_ERROR);
        counters = system.getCounters("username");
        String id = counters.get(0).getCounterId();
        double origin = counters.get(0).getValue();
        double step = counters.get(0).getStep();
        System.out.println(origin);
        System.out.println(step);
        System.out.println(id);
        assertNotEquals(step, 0, DELTA);
        assertEquals(system.count(id), 0);
        assertEquals(system.getCounter(id).getValue(), origin + step, DELTA);
        assertEquals(system.count(id, true), 0);
        assertEquals(system.getCounter(id).getValue(), origin, DELTA);

        assertEquals(system.count("noId"), Finals.COUNTER_NOT_EXIST);
    }

}
*/
