package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    private String code;
    private String name;

    // Empty constructor with debug log
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    // Getters with debug
    public String getCode() {
        LOGGER.debug("Inside getCode()");
        return code;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        return name;
    }

    // Setters with debug
    public void setCode(String code) {
        LOGGER.debug("Inside setCode()");
        this.code = code;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName()");
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
