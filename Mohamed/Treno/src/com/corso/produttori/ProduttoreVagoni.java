package com.corso.produttori;

import com.corso.vagoni.Cargo;
import com.corso.vagoni.Carrozza;
import com.corso.vagoni.Locomotiva;
import com.corso.vagoni.Ristorante;

public interface ProduttoreVagoni {
	
	Carrozza produciCarrozza();
	Locomotiva produciLocomotiva();
	Cargo produciCargo();
	Ristorante produciRistorante();
	

}
