package com.agl.test.controller;

import com.agl.app.PeopleApplication;
import com.agl.controller.PeopleController;
import com.agl.model.Pet;
import com.agl.service.PeopleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller level test cases using mockito
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PeopleController.class)
@ContextConfiguration(classes = {PeopleApplication.class})
public class PeopleControllerTest {

    private static final Logger logger = LogManager.getLogger(PeopleControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PeopleService peopleService;

    @Test
    public void testGetPeopleData() throws Exception {
        Map results =
                getPeopleInfo();
        when(peopleService.fetchPeopleData()).thenReturn(results);
        mvc.perform(get("/api/people"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", is(notNullValue())));

        verify(peopleService, times(1)).fetchPeopleData();
    }

    private Map<String, Set> getPeopleInfo() {
        Map results = new HashMap();
        ArrayList pets = new ArrayList();
        Pet p = new Pet();
        p.setName("Bourban");
        p.setType("Golden Retriever");
        pets.add(p);
        results.put("Male", pets);
        return results;
    }
}
