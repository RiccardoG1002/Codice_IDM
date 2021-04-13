public class StudenteOperaio extends Operaio implements Alunno {

	private String matricola;
	
	public StudenteOperaio(String nome, String cognome, String mansione, String matricola) {
		super(nome, cognome, mansione);
		this.matricola = matricola;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.matricola;
	}
	
	@Override
	public String stampaDatiPersonalizzati() {
		return super.stampaDatiPersonalizzati() + " Matricola: " + this.matricola;
	}

	@Override
	public double madiaVoti() {
		return 0;
	}
	
	@Override
	public double calcoloStipendio() {
		return super.calcoloStipendio();
	}
}
