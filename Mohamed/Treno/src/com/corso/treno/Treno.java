package com.corso.treno;

import java.util.LinkedList;

import com.corso.exceptions.PesoEccessoException;
import com.corso.vagoni.Carrozza;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Vagone;

public class Treno {
	
	private LinkedList<Vagone> vagoni;
	private double peso = 0;
	private int numeroPassegeri = 0;
	private double maxTrainabile = -1;
	
	
	public LinkedList<Vagone> getVagoni() {
		return vagoni;
	}

	public double getPeso() {
		return peso;
	}

	public int getNumeroPassegeri() {
		return numeroPassegeri;
	}

	Treno(){
		this.vagoni = new LinkedList<>();
	}
	
	public void addVagone(Vagone vagone) {
		if(vagone instanceof Locomotiva && maxTrainabile <0)
			maxTrainabile = ((Locomotiva) vagone).getMaxPesoTrainabile();
		
		if (vagone instanceof Carrozza)
			numeroPassegeri += (((Carrozza) vagone).getNumeroPosti());
		
		vagoni.add(vagone);
		peso += vagone.getmaxPeso();
		
			
		if(peso > maxTrainabile) throw new PesoEccessoException(peso, maxTrainabile);	
	}

	@Override
	public String toString() {
		String s= "";	
		for (Vagone v: vagoni)
			s = s.concat(v.toString());
		
		s = s.concat("\n").concat("capienza passegeri: "+ getNumeroPassegeri());
		s= s.concat("\n").concat("peso massimo: "+ getPeso());
		
		return s;
	}
	
	

}
