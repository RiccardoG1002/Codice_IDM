package com.corso.azienda;

import java.util.Map;

import com.persone.OperaioConcreto;

public class GruppoOperai {
	
	private Map<String, OperaioConcreto> operai;
	
	

	public GruppoOperai(Map<String, OperaioConcreto> operai) {
		super();
		this.operai = operai;
	}

	public Map<String, OperaioConcreto> getOperai() {
		return operai;
	}

	public void stampaOperai() {
		for(String codice : operai.keySet()) {
			operai.get(codice).stampaDati();
			System.out.println();
		}
	}
	
	
	

}
