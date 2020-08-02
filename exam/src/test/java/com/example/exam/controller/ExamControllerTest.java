package com.example.exam.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

//@WebMvcTest(ExamController.class) // @WebMVCTest is to test only a controller, cant be used with @SpringBootTest which is for whole app test
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc  // commented out because we are testing REST api
public class ExamControllerTest {
 
	/*
	 * added (webEnvironment=WebEnvironment.RANDOM_PORT) above as:
	 *  Test env starts the web container and listens for HTTP requests:
	 *  this makes TestRestTemplate available for DI
	 */
	@Autowired
    private TestRestTemplate template; 
	
//    @Autowired
//    private MockMvc mockMvc;
 
 
//    @WithMockUser(value = "john")
    @Test
    public void unAuthenticatedAccess_shouldDenyWith403() throws Exception {

    	HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
	    personJsonObject.put("username", "john");
	    personJsonObject.put("password", "password");
	    HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), authHeaders);
        JsonNode loginResponse = template.postForObject("/authenticate",  request, JsonNode.class);
        System.out.println("**********Test /authenticate JWT token response: "+ loginResponse);
        assertNotNull(loginResponse.get("token"));
        
        
        authHeaders.set("Authorization","Bearer " +loginResponse.get("token").textValue() );
        ResponseEntity<String> response = template.exchange("/hello",
                HttpMethod.GET,
                new HttpEntity<>(null, authHeaders),
                String.class
        );
        System.out.println("++++++++++ Test /hello response: "+ response.toString());
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}