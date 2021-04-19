package com.progetto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.corso.algoritmi.SimilarString;
import com.corso.azienda.GruppoOperai;
import com.corso.caffe.Caffe;
import com.persone.Operaio;
import com.persone.OperaioConcreto;

import decorator.*;
import figureGeometriche.*;
import test.TestStringhe;


public class TestProgetto {
	
	private static final String beans_figure = "beans/beans_figure.xml";
	private static final String beans_caffe = "beans/beans_caffe.xml";
	private static final String beans_stringhe = "beans/beans_stringhe.xml";
	private static final String beans_studente_operaio ="beans/beans_studente_operaio.xml";
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(beans_studente_operaio);
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans/beans_caffe.xml");
		//testFigureComposte(context);
		testStudenteOperaio(context);
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
	
	private static void testCaffe(ApplicationContext context) {
		Caffe c = (Caffe) context.getBean("CaffeZuccherato");
		c.prepara();
	}
	
	private static void testSimilarStrings(ApplicationContext context) {
		SimilarString similarString = (SimilarString) context.getBean("checkString");
		
		System.out.println("Best match: "+ similarString.getMostSimilar("Italia", TestStringhe.fromFile("countries.txt")));
		System.out.println("By: "+ similarString.getLastAlgo());
	}
	
	private static void testFigureComposte(ApplicationContext context) {
		Figura fig = (Figura) context.getBean("figura03");
		System.out.println("Area figura composta: "+ fig.getArea());
	}
	
	private static void testStudenteOperaio(ApplicationContext context) {
		//OperaioConcreto alessandro = (OperaioConcreto) context.getBean("Alessandro");
		// alessandro.stampaDati();
		GruppoOperai go = (GruppoOperai) context.getBean("operai_gruppo");
		go.stampaOperai();
	}
}
