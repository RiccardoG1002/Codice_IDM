package com.corso.dizionario;

import java.util.Collection;

import com.corso.paesi.Paese;

import test.TestStringhe;

public class DizionarioDaFile implements Dizionario{
    
	public Collection<String> getParoleStd() {
		return TestStringhe.fromFile("src/main/resources/countries.txt");
		
	}

	

}
