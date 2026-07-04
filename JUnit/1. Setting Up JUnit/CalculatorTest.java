package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        assertEquals(8, c.add(3, 5));
    }
}
