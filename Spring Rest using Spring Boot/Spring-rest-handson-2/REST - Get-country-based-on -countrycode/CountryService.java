package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private List<Country> countries;

    public CountryService() {
        LOGGER.info("Inside CountryService Constructor");
        loadCountries();
    }

    private void loadCountries() {
        LOGGER.info("Loading countries from XML...");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        countries = new ArrayList<>();

        // Get all country beans from XML
        countries.add((Country) context.getBean("us"));
        countries.add((Country) context.getBean("de"));
        countries.add((Country) context.getBean("in"));
        countries.add((Country) context.getBean("jp"));

        LOGGER.info("Loaded {} countries", countries.size());
    }

    public Country getCountry(String code) {
        LOGGER.info("START: getCountry() called with code: {}", code);

        // Method 1: Using for-each loop (Traditional way)
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.info("END: Found country: {}", country);
                return country;
            }
        }

        LOGGER.error("Country not found with code: {}", code);
        return null;
    }
}
