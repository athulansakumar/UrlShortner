package com.athulansakumar.web;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.PatternMatchUtils;

import static org.hamcrest.Matchers.isEmptyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UrlShortnerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getRoot() throws Exception {
        String url= "testUrl";
        mvc.perform(MockMvcRequestBuilders.get("/"+url).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://google.com"));
    }

    @Test
    public void createShortUrl() throws Exception {
        String url= "http//google.com";
        mvc.perform(MockMvcRequestBuilders.post("/create").content(url).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.not(isEmptyString())));
    }
}