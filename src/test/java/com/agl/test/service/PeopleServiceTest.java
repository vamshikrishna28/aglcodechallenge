package com.agl.test.service;

import com.agl.model.People;
import com.agl.model.Pet;
import com.agl.service.PeopleService;
import com.agl.ws.PeopleWsAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Service layer Test Case
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class PeopleServiceTest {

    @Before
    public void setup() {
        People[] resultsArray = new People[1];
        resultsArray[0] = getPeopleData();
        Mockito.when(peopleWsAdapter.fetchPersonDetails()).thenReturn(resultsArray);
    }

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private PeopleWsAdapter peopleWsAdapter;

    @Test
    public void testGetPeopleData() {
        Map results = peopleService.fetchPeopleData();
        Assert.assertFalse(results.isEmpty());
    }

    private People getPeopleData() {
        People people = new People();
        people.setName("Sam");
        people.setGender("Male");
        people.setAge(30l);
        List<Pet> petsList = new ArrayList();
        Pet pet = new Pet();
        pet.setType("Retreiver");
        pet.setName("ChoCho");
        petsList.add(pet);
        people.setPets(petsList);
        return people;
    }
}