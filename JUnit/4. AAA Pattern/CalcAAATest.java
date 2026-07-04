package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcAAATest {

    private CalcAAA c;
    @Before
    public void setup(){
        System.out.println("Before each method");
        c = new CalcAAA();
    }

    @Test
    public void addTest(){
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void subtractTest(){
        assertEquals(6, c.subtract(8, 2));
    }

    @After
    public void teardown(){
        System.out.println("After each method");
    }
}
