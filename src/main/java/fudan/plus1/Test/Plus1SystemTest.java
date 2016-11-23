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

    }


}
