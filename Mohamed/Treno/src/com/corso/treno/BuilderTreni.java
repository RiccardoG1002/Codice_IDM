package com.corso.treno;

import java.util.regex.Pattern;

import com.corso.exceptions.*;
import com.corso.produttori.ProduttoreVagoni;
import com.corso.vagoni.Cargo;
import com.corso.vagoni.Ristorante;
import com.corso.vagoni.Vagone;

public abstract class BuilderTreni {
	
	private ProduttoreVagoni produttore;
	private Treno treno;
	
	public BuilderTreni(String string_treno, ProduttoreVagoni produttore){
		if (Pattern.matches(".*[0-9]+.*", string_treno)) throw new NumberInCodeException();
		if(!Pattern.matches("H.*", string_treno)) throw new LocomotivaNonInTestaException();
		if(Pattern.matches(".+H.+", string_treno)) throw new LocomotivaNonInTestaException();
		if(Pattern.matches("H{2,}.*", string_treno) || Pattern.matches(".*H{2,}", string_treno)) throw new TroppeLocomotive();
		if(Pattern.matches("H{2,}", string_treno)) throw new TroppiRistorantiException();
		if(Pattern.matches(".*C+.*R+.*", string_treno) || Pattern.matches(".*R+.*C+.*", string_treno)) throw new CargoAndRristoranteException();		
		this.produttore = produttore;
		
		Treno treno = new Treno();

		for (char c: string_treno.toCharArray()) {
			
			switch(c) {
			case 'H':
				treno.addVagone(produttore.produciLocomotiva());
				break;
			case 'R':
				treno.addVagone(produttore.produciRistorante());
				break;
			case 'P':
				treno.addVagone(produttore.produciCarrozza());
				break;
			case 'C':
				treno.addVagone(produttore.produciCargo());
				break;
			default: 
				throw new VagoneNonPrevistoException(c);
			}
		}
		
	   this.treno = treno;
	}

	public Treno getTreno() {
		return treno;
	}
	
	

}
