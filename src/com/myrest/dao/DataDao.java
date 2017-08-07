package com.myrest.dao;

import java.util.List;
import org.json.JSONObject;

import com.myrest.model.Calculator;

public interface DataDao {

	public List<Calculator> getCalculationHistory() throws Exception;  
	public JSONObject performCalculation(Calculator cal) throws Exception;
}
