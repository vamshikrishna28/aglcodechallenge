package com.agl.service;

import com.agl.comparator.PetComparator;
import com.agl.model.People;
import com.agl.model.Pet;
import com.agl.ws.PeopleWsAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PeopleService {

    private static final Logger logger = LogManager.getLogger(PeopleService.class);

    @Autowired
    private PeopleWsAdapter peopleWsAdapter;


    /**
     *
     * This method fetches data from the adapters and processes the data to produce
     * a map with keys - Male/Female and values being a collection of Pet entities sorted in ascending order
     */
    public Map<String, Set<Pet>> fetchPeopleData(){
        People[] data = peopleWsAdapter.fetchPersonDetails();
        logger.debug("Data received from webservice adapter: "+data);
        return processPeopleData(data);
    }

    /**
     *     Used custom collector to help with sorting the collections using comparator.
     *     Also used TreeSet as the preferred data structure over other collections for two reasons - eliminates duplicates & sorting
     */
    private Map<String, Set<Pet>> processPeopleData(People[] peopleArray) {
        Stream<People> stream = Arrays.stream(peopleArray);
        Map<String, Set<Pet>> processedMap;
        processedMap = stream.collect(Collectors.groupingBy(People::getGender, Collectors.mapping(People::getPets,
                Collector.of(() -> new TreeSet<>(new PetComparator()),
                        ((accumulator, o1) -> {
                            if (o1 != null)
                                accumulator.addAll(o1);
                        }),
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        })
        )));
        logger.debug("Processed people data: "+processedMap);
        return processedMap;
    }
}
