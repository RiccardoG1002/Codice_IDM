package com.corso.azienda;
import java.util.ArrayList;
import java.util.List;

import com.persone.OperaioConcreto;
import com.persone.Persona;
import com.persone.StudenteConcreto;
import com.persone.StudenteOperaio;
import com.persone.Studente;

public class AziendaTest {

		public static void main (String args[]) {
			
			Studente studente = new StudenteConcreto("Mario", "Rossi", "MAT1234567890"); 
			OperaioConcreto operaio = new OperaioConcreto("Alessandro", "Rossi", "Muratore");
			StudenteOperaio studenteOperaio = new StudenteOperaio("Marco", "Rossi", "MAT233213892354", "Manutenzione");
			
			List<Studente> studenti = new ArrayList<Studente>();
			studenti.add(studenteOperaio);
			studenti.add(studente);
			
			for (Studente s: studenti){
				((Persona) s).stampaDati();
			}
		}
}
