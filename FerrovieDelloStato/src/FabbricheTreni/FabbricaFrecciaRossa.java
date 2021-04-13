package FabbricheTreni;

import ComponentiTreni.ComponenteTreno;
import ComponentiTreni.MotriceFrecciaRossa;
import ComponentiTreni.VagoneBagnoFR;
import ComponentiTreni.VagoneCargoFR;
import ComponentiTreni.VagonePasseggeriFR;
import ComponentiTreni.VagoneRistoranteFR;

public class FabbricaFrecciaRossa implements FabbricaTreni{

	@Override
	public ComponenteTreno costruisciMotrice() {
		return new MotriceFrecciaRossa();
	}

	@Override
	public ComponenteTreno costruisciVagonePasseggeri() {
		return new VagonePasseggeriFR();
	}

	@Override
	public ComponenteTreno costruisciVagoneCargo() {
		return new VagoneCargoFR();
	}

	@Override
	public ComponenteTreno costruisciVagoneRistorante() {
		return new VagoneRistoranteFR();
	}

	@Override
	public ComponenteTreno costruisciVagoneBagno() {
		return new VagoneBagnoFR();
	}

}
