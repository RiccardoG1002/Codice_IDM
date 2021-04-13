public abstract class Persona {
	private String nome;
	private String cognome;
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public final void stampaDati() {
		System.out.println("dati anagrafici: " + nome + " " + cognome + " " + stampaDatiPersonalizzati());
	}
	
	@Override
	public String toString() {
		return "nome = " + this.nome + ", cognome = " + this.cognome;
	}
	
	public abstract String stampaDatiPersonalizzati();
}