package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import javax.annotation.PostConstruct; 
import java.util.List;
import java.util.stream.Collectors; 

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private List<Country> countryList; 

    @PostConstruct
    public void init() {
        LOGGER.info("START - CountryService init() method");
       
        LOGGER.debug("Loaded countries from XML (via @Autowired): {}", countryList);
        LOGGER.info("END - CountryService init() method");
    }

    public Country getCountry(String code) {
        LOGGER.info("START - getCountry({}) method", code);

        
        Country foundCountry = countryList.stream()
                                          .filter(country -> country.getCode().equalsIgnoreCase(code))
                                          .findFirst()
                                          .orElse(null);

        LOGGER.info("END - getCountry({}) method - Found: {}", code, foundCountry);
        return foundCountry;
    }

    public List<Country> getAllCountries() {
        return countryList;
    }
}
