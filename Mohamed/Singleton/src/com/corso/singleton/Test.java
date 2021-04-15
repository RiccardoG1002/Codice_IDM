package com.corso.singleton;

public class Test {
	
	public static void main(String args[]) {
		
		Unico u = Unico.getIstanza();
		Unico u1 = Unico.getIstanza();
		
		System.out.println(u);
		System.out.println(u1);
	}

}
