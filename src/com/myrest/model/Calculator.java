package com.myrest.model;

import java.io.Serializable;  

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
  
import org.codehaus.jackson.annotate.JsonIgnoreProperties; 

@Entity  
@Table(name = "Calculation")  
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Calculator implements Serializable {
	@Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	 @Column(name = "id")  
	 private long id;  
	
	@Column(name = "input1")  
	 private int input1;  
	  
	 @Column(name = "input2")  
	 private int input2;
	 
	/*@Column(name = "operand1")  
	 private int operand1;  
	  
	 @Column(name = "operand2")  
	 private int operand2;  
	*/  
	 @Column(name = "operationType")  
	 private String operationType;  
	  
	 public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	public int getInput2() {
		return input2;
	}

	public void setInput2(int input2) {
		this.input2 = input2;
	}

	@Column(name = "result")  
	 private int result;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
*/
	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}  
}
