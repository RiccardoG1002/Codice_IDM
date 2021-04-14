package com.figure.test;

import java.util.ArrayList;
import java.util.List;

import costruzioni.Muratore;
import decorator.*;
import figureGeometriche.Cerchio;
import figureGeometriche.Figura;
import figureGeometriche.FiguraComposta;
import figureGeometriche.Quadrato;
import figureGeometriche.Quadrilatero;
import figureGeometriche.Rettangolo;
import figureGeometriche.Rombo;
import figureGeometriche.Stella;

public class progetto {
	
	public static void main(String[] args) {

		Figura stanza = new Rettangolo(400,500);
		Rettangolo mattonella = new Rettangolo(50,100);
		Quadrato quadrato = new Quadrato(20);
		Cerchio vetro= new Cerchio(20);

//		Muratore piero = new Muratore("Piero");
//
//		System.out.println(
//				"Mi servono num.mattonelle: "+ piero.calcolaNumeroMattonelle(stanza, mattonella));  
//
//		piero.faiMosaico(quadrato);   
//
//		piero.costruisciOblo(vetro); 
//		
//		Quadrato mattonellaQ = new Quadrato(30);
//		
//		piero.calcolaNumeroMattonelle(stanza, mattonellaQ);
		
		
//		Quadrato q= new Quadrato(2);
//		System.out.println("Perimetro del quadrilatero: " + q.getPerimetro());
//		System.out.println("Area del quadrilatero: " + q.getArea());
//		
		Quadrato q_grande = new Quadrato(4);
		Quadrato q_piccolo = new Quadrato(2);
		Rettangolo rettangolo = new Rettangolo(4,2);
		
		List<Figura> figure = new ArrayList<Figura>();
		figure.add(q_grande);
		figure.add(q_piccolo);
		figure.add(rettangolo);
		
		FiguraComposta mattonellaComposta = new FiguraComposta(figure);
		
		/*
		 * Muratore piero = new Muratore("Piero");
		 * 
		 * 
		 * System.out.println( "Mi servono num.mattonelle: "+
		 * piero.calcolaNumeroMattonelle(stanza, mattonellaComposta));
		 * 
		 * Stella s= new Stella(2); System.out.println("Area della stella: " +
		 * s.getArea()); s.stampaAreaSottofigure();
		 */
		
		
		
		testCompare();
		
		
	
	}
	
	
	public static void testCompare() {
		Rettangolo r1 = new Rettangolo(10,10);
		Rettangolo r2 = new Rettangolo(20,10);
		
		FiguraColorata fc = new FiguraColorata(r1, "blu");
		FiguraConBordo fb = new FiguraConBordo(r2, 12,"giallo");
		
		fb.stampaProprieta();
		
		System.out.println("Compare r1 and r2: "+ fb.compareTo(fc) );
	}
}



