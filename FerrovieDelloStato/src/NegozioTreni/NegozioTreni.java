package NegozioTreni;

import ComponentiTreni.ComponenteTreno;
import ComponentiTreni.Motrice;
import Exceptions.PesoEccessivoException;
import Treni.Treno;

public abstract class NegozioTreni {

	/**
	 * crea un treno partendo dalla stringa in input
	 * 
	 * @param ordine: stringa che rappresenta il treno
	 * @return: treno creato
	 * @throws Exception: lancia eccezione se il treno supera il peso trainabile
	 *                    dalla motrice
	 */
	public final Treno ordinaTreno(String ordine) throws Exception {
		Treno treno = this.ordinaTrenoPersonalizzato();
		for (int i = 1; i < ordine.length(); i++) {
			treno.aggiungiVagone(this.aggiungiCarrozzaPersonalizzata(ordine.charAt(i)));
		}
		if (!controllaPeso(treno, this.aggiungiCarrozzaPersonalizzata(ordine.charAt(0))))
			throw new PesoEccessivoException();
		treno.aggiungiMotrice(this.aggiungiCarrozzaPersonalizzata(ordine.charAt(0)));
		return treno;
	}

	/**
	 * controlla che il peso massimo del treno non superi il peso trainabile dalla
	 * motrice
	 * 
	 * @param treno:   treno senza motrice
	 * @param motrice: motrice da creare
	 * @return: {@value true} se il peso del treno non supera il peso trainabile
	 *          dalla motrice
	 */
	private boolean controllaPeso(Treno treno, ComponenteTreno motrice) {
		if (treno.pesoMassimo() > ((Motrice) motrice).pesoTrainabile())
			return false;
		return true;
	}

	/**
	 * aggiunge le carrozze rappresentate nella stringa al treno passato come
	 * parametro
	 * 
	 * @param ordine: stringa che rappresenta le carrozze da aggiungere
	 * @param treno:  treno da modificare
	 * @return: treno modificato
	 * @throws Exception: se il peso del treno supera il peso trainabile dalla
	 *                    motrice
	 */
	public final Treno aggiungiCarrozza(String ordine, Treno treno) throws Exception {
		for (int i = 0; i < ordine.length(); i++) {
			treno.aggiungiVagone(this.aggiungiCarrozzaPersonalizzata(ordine.charAt(i)));
			if (!controllaOrdineAggiunta(treno))
				throw new PesoEccessivoException();
		}
		return treno;
	}

	/**
	 * controlla che il peso del treno dopo l'ordine non superi il peso trainabile
	 * dalla motrice
	 * 
	 * @param treno: treno da controllare
	 * @return: {@value true} se il peso del treno non supera quello trainabile
	 *          dalla motrice
	 */
	private boolean controllaOrdineAggiunta(Treno treno) {
		if (treno.pesoMassimo() > ((Motrice) treno.motrice()).pesoTrainabile())
			return false;
		return true;
	}

	/**
	 * ritorna il treno, dipende dal tipo di treno selezionato
	 * 
	 * @return: treno creato
	 */
	public abstract Treno ordinaTrenoPersonalizzato();

	/**
	 * ritorna il vagone selezionato, dipende dal tipo di treno che si vuole
	 * ordinare
	 * 
	 * @param tipoCarrozza: carattere che rappresenta la carrozza da creare
	 * @return: carrozza creata
	 */
	public abstract ComponenteTreno aggiungiCarrozzaPersonalizzata(char tipoCarrozza);

}
