package org.example;


import org.junit.Test;

import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions(){
        assertEquals(5, 2+3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNotNull(new Object());
        assertNull(null);

        int[] a1 = {1, 2};
        int[] a2 = {1, 2};
        assertArrayEquals(a1, a2);
    }


}
