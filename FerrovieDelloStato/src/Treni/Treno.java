package Treni;

import java.util.LinkedList;
import ComponentiTreni.ComponenteTreno;
import ComponentiTreni.VagonePasseggeri;
import Exceptions.TroppiPasseggeriException;
import NegozioTreni.NegozioTreni;

public abstract class Treno {

	private LinkedList<ComponenteTreno> treno;

	public Treno() {
		this.treno = new LinkedList<ComponenteTreno>();
	}

	/**
	 * aggiunge un vagone al treno
	 * 
	 * @param vagone: vagone da aggiungere
	 */
	public final void aggiungiVagone(ComponenteTreno vagone) {
		this.treno.add(vagone);
	}

	/**
	 * aggiunge la motrice in testa al treno
	 * {@link NegozioTreni#ordinaTreno(String)}
	 * 
	 * @param motrice: motrice da aggiungere
	 */
	public final void aggiungiMotrice(ComponenteTreno motrice) {
		this.treno.addFirst(motrice);
	}

	/**
	 * 
	 * @return
	 */
	public final ComponenteTreno motrice() {
		return this.treno.get(0);
	}

	/**
	 * accende il treno
	 */
	public final void accendi() {
		this.accendiPersonalizzata();
		System.out.print("\n");
	}

	/**
	 * stampa a video il treno
	 */
	public final void mostra() {
		for (ComponenteTreno componenteTreno : treno) {
			componenteTreno.stampa();
		}
		System.out.print("\n");
	}

	/**
	 * aggiunge dei passeggeri ai {@link VagonePasseggeri} contenuti nel treno
	 * 
	 * @param numeroPasseggeri: numero di passeggeri da aggiungere
	 * @throws Exception: lancia un'eccezione se il numero di passeggeri da
	 *                    aggiungere supera il numero di posti liberi
	 */
	public final void aggiungiPasseggeri(int numeroPasseggeri) throws Exception {
		if (numeroPasseggeri > capienza())
			throw new TroppiPasseggeriException(capienza());
		for (ComponenteTreno componenteTreno : treno) {
			if (componenteTreno instanceof VagonePasseggeri) {
				if(numeroPasseggeri <= 0) return;
				if (((VagonePasseggeri) componenteTreno).capienzaVagone() != 0) {
					int capienzaVagone = ((VagonePasseggeri) componenteTreno).capienzaVagone();
					if (capienzaVagone > numeroPasseggeri)
						((VagonePasseggeri) componenteTreno).aggiungiPassegggeri(numeroPasseggeri);
					else
						((VagonePasseggeri) componenteTreno).aggiungiPassegggeri(capienzaVagone);
					numeroPasseggeri = numeroPasseggeri - capienzaVagone;
				}
			}
		}
	}

	/**
	 * calcola il peso del treno a pieno carico
	 * 
	 * @return: peso del treno
	 */
	public final double pesoMassimo() {
		double peso = 0;
		for (ComponenteTreno componenteTreno : treno) {
			if (componenteTreno instanceof VagonePasseggeri)
				peso = peso + ((VagonePasseggeri) componenteTreno).pesoMassimo();
			else
				peso = peso + componenteTreno.peso();
		}
		return peso;
	}

	/**
	 * calcola il peso effettivo del treno
	 * 
	 * @return: peso del treno
	 */
	public final double peso() {
		double peso = 0;
		for (ComponenteTreno componenteTreno : treno) {
			peso = peso + componenteTreno.peso();
		}
		return peso;
	}

	/**
	 * calcola il numero di posti liberi nei {@link VagonePasseggeri} del treno
	 * 
	 * @return: numero di posti liberi
	 */
	private int capienza() {
		int capienza = 0;
		for (ComponenteTreno componenteTreno : treno) {
			if (componenteTreno instanceof VagonePasseggeri)
				capienza = capienza + ((VagonePasseggeri) componenteTreno).capienzaVagone();
		}
		return capienza;
	}

	/**
	 * accende il treno, varia a seconda del tipo di treno
	 */
	protected abstract void accendiPersonalizzata();

}