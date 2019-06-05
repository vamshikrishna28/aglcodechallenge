package com.agl.controller;

import com.agl.model.Pet;
import com.agl.service.PeopleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private static final Logger logger = LogManager.getLogger(PeopleController.class);

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public ResponseEntity<?> getPeopleData() {
        Map<String, Set<Pet>> resultMap = peopleService.fetchPeopleData();

        if (resultMap.isEmpty()) {
            logger.debug("No data returned from the service");
            return new ResponseEntity<>("Sorry unable to fetch People Data!!!!", HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}
