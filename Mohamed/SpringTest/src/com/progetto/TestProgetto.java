package com.progetto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import decorator.*;
import figureGeometriche.*;


public class TestProgetto {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		testDecorators(context);
	}
	
	
	private static void testCerchi(ApplicationContext context) {

		Cerchio figura1 = (Cerchio) context.getBean("cerchio01");
		Cerchio figura2 = (Cerchio) context.getBean("cerchio01");
		
		System.out.println("istanza: "+ figura1);
		System.out.println("istanza: "+ figura2);
		
		System.out.println("Area della figura2: "+ + figura2.getArea());
		figura1.setRaggio(5.00);
		System.out.println("Area della figura2: "+ + figura2.getArea());
	}
	
	private static void testSingleton(ApplicationContext context) {

		FiguraUnica f1 = (FiguraUnica) context.getBean("figuraUnica01");
		FiguraUnica f2 = (FiguraUnica) context.getBean("figuraUnica02");
		
		System.out.println("istanza: "+ f1);
		System.out.println("istanza: "+ f2);
		
	}
	
	private static void testDecorators(ApplicationContext context) {
		FiguraDecorata fd = (FiguraDecorata) context.getBean("figura02");
		fd.stampaProprieta();
		
		
	}
}
