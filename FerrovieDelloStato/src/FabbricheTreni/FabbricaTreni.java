package FabbricheTreni;

import ComponentiTreni.ComponenteTreno;

public interface FabbricaTreni {
	ComponenteTreno costruisciMotrice();
	ComponenteTreno costruisciVagonePasseggeri();
	ComponenteTreno costruisciVagoneCargo();
	ComponenteTreno costruisciVagoneRistorante();
	ComponenteTreno costruisciVagoneBagno();
}
