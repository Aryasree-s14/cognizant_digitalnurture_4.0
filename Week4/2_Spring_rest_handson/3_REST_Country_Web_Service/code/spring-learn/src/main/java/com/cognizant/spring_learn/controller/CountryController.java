package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

   
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

   
    @RequestMapping(value = "/country", method = RequestMethod.GET) 
    public Country getCountryIndia() {
       
        LOGGER.info("START - getCountryIndia() method");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        LOGGER.info("ApplicationContext loaded from country.xml.");

        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Retrieved Country bean: {}", country.toString());

        if (context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
            LOGGER.info("ClassPathXmlApplicationContext for country.xml closed.");
        }

       
        LOGGER.info("END - getCountryIndia() method");

        return country;
    }
}

