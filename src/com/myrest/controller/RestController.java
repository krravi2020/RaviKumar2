package com.myrest.controller;

import java.util.List;  

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.MediaType;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;

import com.myrest.dao.DataDao;
import com.myrest.model.Calculator;  
@Controller 
 
public class RestController {  
  
 @Autowired  
 DataDao dataDao;  
  
 static final Logger logger = Logger.getLogger(RestController.class);  
  
 /* Submit form in Spring Restful Services */  
 @RequestMapping(value = "/Calculate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)  
 public @ResponseBody String performCalculation(@RequestBody Calculator calculator) throws Exception {  
   
	  JSONObject ob=dataDao.performCalculation(calculator);
	  return ob.toString();
	  /*System.out.println("came here");
	  JSONObject obj=new JSONObject();
	  obj.put("status", "false");
	  obj.put("result", result);
	  */ 
  
  
 }
 
  
 @RequestMapping(value = "/getCalculationHistory", method = RequestMethod.GET)  
 public @ResponseBody List<Calculator> 
 getCalculationHistory() throws Exception {   
 
	List<Calculator>cal=dataDao.getCalculationHistory();
	return cal;

 }
 }