package com.corso.produttori;

import com.corso.vagoni.Cargo;
import com.corso.vagoni.Carrozza;
import com.corso.vagoni.CarrozzaA;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.LocomotivaA;
import com.corso.vagoni.Ristorante;
import com.corso.vagoni.RistoranteA;

public class LineaA implements ProduttoreVagoni {
	
	
	@Override
	public Carrozza produciCarrozza() {
		return new CarrozzaA();
	}

	@Override
	public Locomotiva produciLocomotiva() {
		return new LocomotivaA();
	}

	@Override
	public Cargo produciCargo() {
		return new Cargo(130);
	}

	@Override
	public Ristorante produciRistorante() {
		return new RistoranteA();
	}

}
