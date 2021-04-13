package FabbricheTreni;

import ComponentiTreni.ComponenteTreno;
import ComponentiTreni.MotriceTrenitalia;
import ComponentiTreni.VagoneBagnoTI;
import ComponentiTreni.VagoneCargoTI;
import ComponentiTreni.VagonePasseggeriTI;
import ComponentiTreni.VagoneRistoranteTI;

public class FabbricaTrenitalia implements FabbricaTreni {

	@Override
	public ComponenteTreno costruisciMotrice() {
		return new MotriceTrenitalia();
	}

	@Override
	public ComponenteTreno costruisciVagonePasseggeri() {
		return new VagonePasseggeriTI();
	}

	@Override
	public ComponenteTreno costruisciVagoneCargo() {
		return new VagoneCargoTI();
	}

	@Override
	public ComponenteTreno costruisciVagoneRistorante() {
		return new VagoneRistoranteTI();
	}

	@Override
	public ComponenteTreno costruisciVagoneBagno() {
		return new VagoneBagnoTI();
	}

}