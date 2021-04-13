package NegozioTreni;

import Exceptions.MotriceNonInTestaException;
import Exceptions.NegozioInesistenteException;
import Exceptions.NessunBagnoException;
import Exceptions.TroppeMotriciException;
import Treni.Treno;

public class VenditoreTreni {

	private NegozioTreni negozio;

	/**
	 * 
	 * @param ordine
	 * @param negozio
	 * @return
	 * @throws Exception
	 */
	public final Treno ordinaTreno(String ordine, int negozio) throws Exception {
		if (controllaNegozio(negozio)) {
			if (controllaOrdine(ordine)) {
				if (negozio == 0)
					this.negozio = new NegozioFrecciaRossa();
				else
					this.negozio = new NegozioTrenitalia();
				return this.negozio.ordinaTreno(ordine);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param ordine
	 * @param negozio
	 * @param treno
	 * @return
	 * @throws Exception
	 */
	public final Treno aggiungiCarrozza(String ordine, int negozio, Treno treno) throws Exception {
		if (controllaNegozio(negozio)) {
			if (controllaAggiunta(ordine)) {
				if (negozio == 0)
					this.negozio = new NegozioFrecciaRossa();
				else
					this.negozio = new NegozioTrenitalia();
				this.negozio.aggiungiCarrozza(ordine, treno);
				return treno;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param ordine
	 * @return
	 * @throws Exception
	 */
	private boolean controllaOrdine(String ordine) throws Exception {
		if (ordine.charAt(0) != 'M') throw new MotriceNonInTestaException();
		if(!ordine.contains("B")) throw new NessunBagnoException();
		for (int i = 1; i < ordine.length(); i++) {
			if(ordine.charAt(i) == 'M') throw new TroppeMotriciException();
		}
		return true;
	}

	/**
	 * 
	 * @param ordine
	 * @return
	 * @throws Exception
	 */
	private boolean controllaAggiunta(String ordine) throws Exception {
		for (int i = 0; i < ordine.length(); i++) {
			if(ordine.charAt(i) == 'M') throw new TroppeMotriciException();
		}
		return true;
	}

	/**
	 * 
	 * @param negozio
	 * @return
	 * @throws Exception
	 */
	private boolean controllaNegozio(int negozio) throws Exception {
		if (negozio < 0 || negozio > 1)
			throw new NegozioInesistenteException();
		return true;
	}
}
