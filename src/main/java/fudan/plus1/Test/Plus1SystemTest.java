package fudan.plus1.Test;

import fudan.plus1.Implementations.Plus1System;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import fudan.plus1.Interfaces.*;

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

        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        assertEquals(100, abstractCounters.size());
        for (int i = 0; i < 100; i++) {
            AbstractCounter abstractCounter = abstractCounters.get(i);
            assertNotNull(abstractCounter.getCounterId());
            assertEquals("name" + i, abstractCounter.getCounterName());
            assertEquals(i, abstractCounter.getValue(), DELTA);
            assertEquals(i, abstractCounter.getStep(), DELTA);
            assertEquals("", abstractCounter.getUnit());
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
        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        for (AbstractCounter abstractCounter : abstractCounters) {

            double originValue = abstractCounter.getValue();

            system.count(abstractCounter.getCounterId());

            assertEquals(abstractCounter.getValue(), originValue + abstractCounter.getStep(), DELTA);
        }
    }

    void testCount1() {
        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        for (AbstractCounter abstractCounter : abstractCounters) {
            double originValue = abstractCounter.getValue();
            system.count(abstractCounter.getCounterId(), true);
            assertEquals(abstractCounter.getValue(), originValue - abstractCounter.getStep(), DELTA);
        }
    }

    void testDeleteCounter() {
        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        int total = 0;
        int originSize = abstractCounters.size();
        List<String> toDeleteCounterId = new ArrayList<String>();
        for (AbstractCounter abstractCounter : abstractCounters) {
            if (!abstractCounter.getCounterId().endsWith("0")) {
                toDeleteCounterId.add(abstractCounter.getCounterId());
                total++;
            }
        }
        for (String s : toDeleteCounterId) {
            system.deleteCounter(s);
        }
        assertEquals(abstractCounters.size() + total, originSize);
    }

    void testChangeCounterInfo() {
        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        Date date = new Date();
        Random random = new Random(date.getTime());
        for (AbstractCounter abstractCounter : abstractCounters) {
            system.changeCounterInfo(abstractCounter.getCounterId(),
                    "" + random.nextInt(10), random.nextDouble(), random.nextDouble(), "" + random.nextInt(10));
            System.out.println(abstractCounter.getCounterId() + " : " + abstractCounter.getCounterName() +
                    " " + abstractCounter.getValue() + " " + abstractCounter.getStep() + " " + abstractCounter.getUnit());
        }
    }

    void testIsCounterCreatedByMe() {
        List<AbstractCounter> abstractCounters = system.getAbstractCounters();
        for (AbstractCounter abstractCounter : abstractCounters) {
            assertTrue(system.isCounterCreatedByMe(abstractCounter.getCounterId()));
        }
    }
}
