package NegozioTreni;

import ComponentiTreni.ComponenteTreno;
import FabbricheTreni.FabbricaFrecciaRossa;
import FabbricheTreni.FabbricaTreni;
import Treni.Treno;
import Treni.TrenoFrecciaRossa;

public class NegozioFrecciaRossa extends NegozioTreni {
	
	private FabbricaTreni fabbrica;

	@Override
	public ComponenteTreno aggiungiCarrozzaPersonalizzata(char tipoCarrozza) {
		if(fabbrica == null) fabbrica = new FabbricaFrecciaRossa();
		if(tipoCarrozza == 'M') return fabbrica.costruisciMotrice();
		else if(tipoCarrozza == 'P') return fabbrica.costruisciVagonePasseggeri();
		else if(tipoCarrozza == 'C') return fabbrica.costruisciVagoneCargo();
		else if(tipoCarrozza == 'B') return fabbrica.costruisciVagoneBagno();
		else if(tipoCarrozza == 'R') return fabbrica.costruisciVagoneRistorante();
		return null;
	}

	@Override
	public Treno ordinaTrenoPersonalizzato() {
		return new TrenoFrecciaRossa();
	}

}
