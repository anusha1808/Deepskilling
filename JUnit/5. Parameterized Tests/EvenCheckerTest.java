package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EvenCheckerTest {

    private final EvenChecker ec = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, -6})

    public void evenCheckTest(int num){
        Assertions.assertTrue(ec.isEven(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, -7})

    public void notEvenCheckTest(int num){
        Assertions.assertFalse(ec.isEven(num));
    }
}
