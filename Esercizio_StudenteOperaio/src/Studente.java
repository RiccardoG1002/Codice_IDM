public class Studente extends Persona implements Alunno{
	//1 dati - propriet�
    //private String nome;
    //private String cognome; 
    private String matricola; 
    
    //2.1 funzionalit� - metodi
    /*public void stampaDati() {
        System.out.println("dati anagrafici: " + nome + 
                " " + cognome + " " + matricola); 
    }*/

    
    //2.2 metodo costruttore
    // ha lo stesso nome della classe
    // crea le istanze
    // si invoca con la parola chiave new
    // pu� essere eseguito una sola volta per una istanza (all'atto della creazione)
    // il tipo di ritorno � un'istanza della classe
    
    public Studente(String nome, String cognome, String matricola) {
        super(nome, cognome); // super � il riferimento alla classe padre, 
        // super() � l'invocazione del metodo costruttore della classe padre 
        //this.nome = nome;
        //this.cognome = cognome;
        this.matricola = matricola;
    }

    // metodo che si occupa della conversione automatica da oggetto a Stringa
    public String toString() {
    	return "Studente [" + super.toString() + ", matricola = " + this.matricola + "]"; 
    }

	@Override
	public String stampaDatiPersonalizzati() {
		return "Matricola: " + this.matricola;
	}

	@Override
	public double madiaVoti() {
		return 0;
	}
}
