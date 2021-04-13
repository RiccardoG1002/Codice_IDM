package com.corso.treno;

import com.corso.produttori.LineaA;
import com.corso.produttori.LineaB;
import com.corso.produttori.ProduttoreVagoni;

public class BuilderTreniB extends BuilderTreni{

	public BuilderTreniB(String string_treno) {
		super(string_treno, new LineaB());
		
	}

}
