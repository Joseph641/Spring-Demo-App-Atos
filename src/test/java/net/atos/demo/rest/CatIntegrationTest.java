package net.atos.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.atos.demo.persistence.domain.Cat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // avoids port conflict, two things run on the same port

@AutoConfigureMockMvc 
// reads th esql scripts in src/main.resources and executes them Before each test 
@Sql(scripts = {"classpath:cat-schema.sql", 
		"classpath:cat-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class CatIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired 
	private ObjectMapper mapper;
	
	
	@Test
	void testCreateCat() throws Exception {
		Cat newCat = new Cat(null, "Manx", 8, "Black", "L");
		String newCatAsJson = this.mapper.writeValueAsString(newCat); 
//		System.out.println(newCatAsJson);
		RequestBuilder request = MockMvcRequestBuilders.post("/create").content(newCatAsJson).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().is(201);
		
		Cat expectedCat = new Cat(2L, newCat.getBreed(), newCat.getAge(), newCat.getColour(), newCat.getSize());
		String expectedCatAsJSON = this.mapper.writeValueAsString(expectedCat);
		ResultMatcher checkBody = content().json(expectedCatAsJSON); 
		
		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testreadAllDogs() throws Exception {
		Cat testCat = new Cat(1L, "Manx", 4, "Black", "L");
		List<Cat> testCats = new ArrayList<>();
		testCats.add(testCat);
		String testCatAsJSON = this.mapper.writeValueAsString(testCats);
		
		
		RequestBuilder request = get("/read");
				
		ResultMatcher checkStatus = status().is(200);
		
		ResultMatcher checkBody = content().json(testCatAsJSON);
		
		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
}
