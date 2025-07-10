package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        
        LOGGER.info("Starting SpringLearnApplication main() method...");

        SpringApplication.run(SpringLearnApplication.class, args);

       
        

        
        displayCountry();

        
        LOGGER.info("SpringLearnApplication main() method finished.");
    }

    
    

    
    private static void displayCountry() {
        LOGGER.info("Starting displayCountry() method...");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        LOGGER.info("ApplicationContext loaded from country.xml.");

        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString()); 
        
        System.out.println("Country Details: " + country);

        
        if (context instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) context).close();
            LOGGER.info("ClassPathXmlApplicationContext for country.xml closed.");
        }
        LOGGER.info("Finished displayCountry() method.");
    }
}
