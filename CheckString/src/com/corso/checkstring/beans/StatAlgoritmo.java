package com.corso.checkstring.beans;

public class StatAlgoritmo implements BeanDTO {
	
	private String algoritmo;
	private int num;
	
	public String getAlgoritmo() {
		return algoritmo;
	}
	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "StatAlgoritmo [algoritmo=" + algoritmo + ", num=" + num + "]";
	}
	
	
	
	

}
