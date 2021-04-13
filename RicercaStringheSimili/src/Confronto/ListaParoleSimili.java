package Confronto;

import java.util.LinkedList;
import java.util.List;

public class ListaParoleSimili {
	
	public static List<String> paroleSimili(String parola, List<String> listaParole) {
		List<String> paroleSimili = new LinkedList<String>();
		for (String string : listaParole) {
			if(Comparatore.confronta(parola, string) > 0.3) 
				paroleSimili.add(string);
		}
		return paroleSimili;
	}
	
}