package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String name = "Anusha";
        int age = 21;

        logger.info("Name: {}, Age: {}", name, age);
    }
}
