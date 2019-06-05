package com.agl.ws;

import com.agl.model.People;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * This is a adapter which connects to the hosted webservice and fetches the data
 */
@Component
public class PeopleWsAdapter {

    private static final Logger logger = LogManager.getLogger(PeopleWsAdapter.class);
    //TODO: To externalise the url as property
    final private String webServiceEndPointUrl = "http://agl-developer-test.azurewebsites.net/people.json";

    public People[] fetchPersonDetails() {

        ObjectMapper objectMapper = new ObjectMapper();

        People[] peopleArray = new People[0];
        try {
            peopleArray = objectMapper.readValue(new URL(webServiceEndPointUrl), People[].class);
            logger.debug("Data received from the webservice"+peopleArray);
        } catch (Exception e) {
            logger.debug("An exception occurred to fetch the webservice details:"+e.getStackTrace());
        }
        return peopleArray;
    }
}
