package com.corso.treno;

import com.corso.produttori.LineaA;
import com.corso.produttori.ProduttoreVagoni;

public class BuilderTreniA extends BuilderTreni {

	public BuilderTreniA(String string_treno) {
		super(string_treno, new LineaA());
	}

}
