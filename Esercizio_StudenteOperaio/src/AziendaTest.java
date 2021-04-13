public class AziendaTest {
	public static void main(String args[]) {

		Persona studente = new Studente("Mario", "Rossi", "MAT1234567890");
		studente.stampaDati();
		Persona operaio = new Operaio("Andrea", "Bianchi", "Operaio");
		operaio.stampaDati();
		GestioneCorsi corsi = new GestioneCorsi();
	}
}
