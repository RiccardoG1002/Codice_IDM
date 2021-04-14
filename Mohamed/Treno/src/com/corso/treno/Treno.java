package com.corso.treno;

import java.util.LinkedList;

import com.corso.exceptions.PesoEccessoException;
import com.corso.vagoni.Carrozza;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Vagone;

public class Treno {
	
	private LinkedList<Vagone> vagoni;
	private Locomotiva locomotiva;
	private int numeroPassegeri = 0;
	
	
	public LinkedList<Vagone> getVagoni() {
		return vagoni;
	}


	public int getNumeroPassegeri() {
		return numeroPassegeri;
	}

	Treno(){
		this.vagoni = new LinkedList<>();
	}
	
	
	
	public Treno(Locomotiva locomotiva, LinkedList<Vagone> vagoni) {
		super();
		this.vagoni = vagoni;
		this.locomotiva = locomotiva;
		if(getPeso() > locomotiva.getMaxPesoTrainabile()) throw new PesoEccessoException(getPeso(), locomotiva.getMaxPesoTrainabile());
	}

	public void addVagone(Vagone vagone) {
		controllaPeso(vagone);
	}
	
	public void addVagone(Carrozza carrozza) {
		numeroPassegeri += carrozza.getNumeroPosti();
		controllaPeso(carrozza);
	}
	
	public double getPeso() {
		double peso = locomotiva.getmaxPeso();
		for(Vagone v: vagoni) {
			peso += v.getmaxPeso();
			
		}
		return peso;
	}

	private void controllaPeso(Vagone vagone){
		if(getPeso() + vagone.getmaxPeso() > locomotiva.getMaxPesoTrainabile()) throw new PesoEccessoException(getPeso()+ vagone.getmaxPeso(), locomotiva.getMaxPesoTrainabile());
		vagoni.add(vagone);
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
