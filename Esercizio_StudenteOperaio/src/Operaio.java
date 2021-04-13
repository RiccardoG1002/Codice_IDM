public class Operaio extends Persona implements Dipendente{
	// private String nome;
	// private String cognome;

	private String mansione;

	/*
	 * public void stampaDati() { System.out.println("dati anagrafici: " + nome +
	 * " " + cognome + " " + mansione); }
	 */

	public Operaio(String nome, String cognome, String mansione) {
		super(nome, cognome);
		// this.nome = nome;
		// this.cognome = cognome;
		this.mansione = mansione;
	}

	@Override
	public String toString() {
		return "Operaio [" + super.toString() + ", mansione = " + this.mansione + "]";
	}

	@Override
	public String stampaDatiPersonalizzati() {
		return ("Mansione: " + this.mansione);
	}

	@Override
	public double calcoloStipendio() {
		return 0;
	}
}
