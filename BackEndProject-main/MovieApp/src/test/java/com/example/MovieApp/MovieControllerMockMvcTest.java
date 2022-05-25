package com.example.MovieApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerMockMvcTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllMoviesAPI() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/movies")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.moves[*].moviesId").isNotEmpty());
    }

    @Test
    public void getMovieByIdAPI() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                        .get("/movies/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.moviesId").value(1));
    }


}
