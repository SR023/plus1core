package Test;

import Implementations.Plus1System;

//import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import Interfaces.*;

/**
 * Created by billlai on 09/Oct/2016.
 */
public class Plus1SystemTest {
    private String username = "LaiWenxing";
    private Plus1System system;
    private final double DELTA = 0.00001;
    @Before
    public void setUp() {
        system = Plus1System.getInstance();
        system.signIn(username, "No password");
    }

    @Test
    public void testAllMethods() {
        assertEquals(system.getUsername(), username);
        testIsCounterIdLegal();

        testCreateSingleUserCounter();

        testCount();
        testCount1();

        testIsCounterCreatedByMe();

        testDeleteCounter();

        testChangeCounterInfo();
    }


    void testCreateSingleUserCounter() {
        for (int i = 0; i < 100; i++) {
            system.createSingleUserCounter("name" + i, i, i, "");
        }

        List<Counter> counters = system.getCounters();
        assertEquals(100, counters.size());
        for (int i = 0; i < 100; i++) {
            Counter counter = counters.get(i);
            assertNotNull(counter.getCounterId());
            assertEquals("name" + i, counter.getCounterName());
            assertEquals(i, counter.getValue(), DELTA);
            assertEquals(i, counter.getStep(), DELTA);
            assertEquals("", counter.getUnit());
        }
    }

    void testIsCounterIdLegal() {
        assertTrue(system.isCounterIdLegal("abcd_1234"));
        assertTrue(system.isCounterIdLegal("abcd"));
        assertTrue(system.isCounterIdLegal("1234"));
        assertTrue(system.isCounterIdLegal("abcd_"));

        assertFalse(system.isCounterIdLegal(""));
        assertFalse(system.isCounterIdLegal("a:1"));
        assertFalse(system.isCounterIdLegal(":"));
        assertFalse(system.isCounterIdLegal("abcd1234-"));
        assertFalse(system.isCounterIdLegal("_"));
        assertFalse(system.isCounterIdLegal("_abcd"));
    }

    void testCount() {
        List<Counter> counters = system.getCounters();
        for (Counter counter : counters) {

            double originValue = counter.getValue();

            system.count(counter.getCounterId());

            assertEquals(counter.getValue(), originValue + counter.getStep(), DELTA);
        }
    }

    void testCount1() {
        List<Counter> counters = system.getCounters();
        for (Counter counter : counters) {
            double originValue = counter.getValue();
            system.count(counter.getCounterId(), true);
            assertEquals(counter.getValue(), originValue - counter.getStep(), DELTA);
        }
    }

    void testDeleteCounter() {
        List<Counter> counters = system.getCounters();
        int total = 0;
        int originSize = counters.size();
        List<String> toDeleteCounterId = new ArrayList<>();
        for (Counter counter : counters) {
            if (!counter.getCounterId().endsWith("0")) {
                toDeleteCounterId.add(counter.getCounterId());
                total++;
            }
        }
        for (String s : toDeleteCounterId) {
            system.deleteCounter(s);
        }
        assertEquals(counters.size() + total, originSize);
    }

    void testChangeCounterInfo() {
        List<Counter> counters = system.getCounters();
        Date date = new Date();
        Random random = new Random(date.getTime());
        for (Counter counter : counters) {
            system.changeCounterInfo(counter.getCounterId(),
                    "" + random.nextInt(10), random.nextDouble(), random.nextDouble(), "" + random.nextInt(10));
            System.out.println(counter.getCounterId() + " : " + counter.getCounterName() +
                    " " + counter.getValue() + " " + counter.getStep() + " " + counter.getUnit());
        }
    }

    void testIsCounterCreatedByMe() {
        List<Counter> counters = system.getCounters();
        for (Counter counter : counters) {
            assertTrue(system.isCounterCreatedByMe(counter.getCounterId()));
        }
    }
}
