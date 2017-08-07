package com.myrest.test;

import org.junit.Test;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import javax.net.ssl.SSLEngineResult.Status;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.myrest.controller.*;
import com.myrest.dao.*;
import com.myrest.model.*;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:/home/ravikumar/Desktop/helloRest/WebContent/WEB-INF/spring-config.xml")
public class calculationTest {

	private MockMvc mockMvc;
	
	@Mock
	private DataDao calculatorService;
	
	@InjectMocks
	private RestController calculatorController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();       
    			 
	 }
	@Test
	public void testingAdd() throws Exception{
		JSONObject jObject = new JSONObject();
		jObject.put("result", 6);
		jObject.put("status", "true");	 
		
		Calculator cal=new Calculator();
		
		cal.setInput1(2);
		cal.setInput2(3);
		cal.setOperationType("Multiply");
		cal.setResult(6);
		
		
		when(calculatorService.performCalculation(cal)).thenReturn(jObject);	
				
		MockHttpServletRequestBuilder request = post("/Calculate");

		
		request.contentType(MediaType.APPLICATION_FORM_URLENCODED);
		request.param("input1", "2");
		request.param("input2", "3");
		request.param("operationType", "Multiply");
		request.param("result", "0");
		
		MvcResult result = mockMvc.perform(request)
		    .andDo(print())
		    .andExpect(status().isOk())
		    .andReturn();
		
		
		String content = result.getResponse().getContentAsString();		
		
		verify(calculatorService, times(1)).performCalculation(cal);
		verifyNoMoreInteractions(calculatorService);
	}
	@Test
	public void testingCalculationHistory() throws Exception{
		
		MvcResult result=(MvcResult) mockMvc.perform(get("/getCalculationHistory"))
        .andExpect(status().isOk());
		
		String content=result.getResponse().getContentAsString();
		
		
	}
	
}
