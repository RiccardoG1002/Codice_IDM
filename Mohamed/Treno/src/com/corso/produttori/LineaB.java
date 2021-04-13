package com.corso.produttori;

import com.corso.vagoni.Cargo;
import com.corso.vagoni.Carrozza;
import com.corso.vagoni.CarrozzaB;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.LocomotivaB;
import com.corso.vagoni.Ristorante;
import com.corso.vagoni.RistoranteB;

public class LineaB implements ProduttoreVagoni{

	@Override
	public Carrozza produciCarrozza() {
	
		return new CarrozzaB();
	}

	@Override
	public Locomotiva produciLocomotiva() {
		return new LocomotivaB();
	}

	@Override
	public Cargo produciCargo() {
		return new Cargo(100);
	}

	@Override
	public Ristorante produciRistorante() {
		return new RistoranteB();
	}

}
