package com.example.MovieApp.MovieControllerTests;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerMockMvcTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnMovieWantedByTitle() throws Exception{
        mvc.perform(get("/movies/title/That Championship Season"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("That Championship Season")));

    }

    @Test
    public void shouldReturnMovieWantedById() throws Exception{
        mvc.perform(get("/movies/id/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("That Championship Season")));

    }


}
