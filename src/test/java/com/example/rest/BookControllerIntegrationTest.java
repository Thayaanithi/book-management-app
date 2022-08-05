package com.example.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookControllerIntegrationTest {
	@Autowired
    private MockMvc mockMVC;

    @Autowired
    private ObjectMapper mapper;

    private final Book TEST_BOOK = new Book(38, "The God", "Thayaani", "Adult", null);

    private final Book TEST_SAVED_BOOK = new Book(20, "The God", "Thayaani", "Adult", null);

    @Test
    public void testCreate() throws JsonProcessingException, Exception {
        String resultString = this.mockMVC
                .perform(post("/book/create").contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(TEST_BOOK)))
                .andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

        Book result = this.mapper.readValue(resultString, Book.class);
        assertThat(result).isEqualTo(TEST_BOOK);
    }

    @Test
    public void testReadOne() throws Exception {
        this.mockMVC.perform(get("/book/read/1")).andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_BOOK)));

    }

    @Test
    public void testReadAll() throws Exception {
        final List<Book> books = new ArrayList<>();
        books.add(TEST_SAVED_BOOK);

        final String resultString = this.mockMVC
                .perform(request(HttpMethod.GET, "/book/read").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        List<Book> results = Arrays.asList(mapper.readValue(resultString, Book[].class));
        assertThat(results).contains(this.TEST_BOOK).hasSize(3);
    }

    @Test
    public void testUpdate() throws Exception {
        final Book newBook= new Book(38, "The God", "Thayaani", "Adult", null);
        String resultString = this.mockMVC
                .perform(put("/book/update/39").contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsString(newBook)))
                .andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

        Book result = this.mapper.readValue(resultString, Book.class);
        assertThat(result).isEqualTo(newBook);
    }

    @Test
    public void testDelete() throws Exception {
        this.mockMVC.perform(delete("/book/delete/17")).andExpect(status().isNoContent());
    }
}



