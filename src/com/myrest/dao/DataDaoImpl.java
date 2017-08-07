package com.myrest.dao;

import java.util.List;


import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;  
import com.myrest.model.Calculator;

class DataDaoImpl  implements DataDao{

	@Autowired  
	 SessionFactory sessionFactory;  
	  
	 Session session = null;  
	 Transaction tx = null;  
	@Override
	public List<Calculator> getCalculationHistory() throws Exception {
		// TODO Auto-generated method stub
		 session = sessionFactory.openSession();  
		  tx = session.beginTransaction();  
		  List<Calculator> calculationHistory = session.createCriteria(Calculator.class)  
		    .list();  
		  tx.commit();  
		  session.close();  
		  return calculationHistory;  
	}

	@Override
	public JSONObject performCalculation(Calculator cal) throws Exception {
		// TODO Auto-generated method stub
		int result;
		JSONObject obj=new JSONObject();
		obj.put("status", "true");
		if(cal.getOperationType().equalsIgnoreCase("Add"))
		{
			//result=cal.getOperand1()+cal.getOperand2();
			result=cal.getInput1()+cal.getInput2();
		}
		else if(cal.getOperationType().equalsIgnoreCase("Substract"))
		{
			result=cal.getInput1()-cal.getInput2();
		}
		else if(cal.getOperationType().equalsIgnoreCase("Multiply"))
		{
			result=cal.getInput1()*cal.getInput2();
		}
		else
		{
			result=cal.getInput1() / cal.getInput2();
		}
		
		obj.put("result", (Integer)result);
		System.out.println("===="+cal.getOperationType()+""+result);
		  cal.setResult(result);		  
		  session = sessionFactory.openSession();  
		  tx = session.beginTransaction(); 
		  session.save(cal);  
		  tx.commit();  
		  session.close();  
		  
		  return obj;
	}

}
