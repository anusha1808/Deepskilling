package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest1 {
    @Test
    public void addTest(){
        Calculator1 c = new Calculator1();
        assertEquals(6, c.add(2, 4));
    }

    @Test
    public void subtractTest(){
        Calculator1 c = new Calculator1();
        assertEquals(1, c.subtract(5, 4));
    }
}
