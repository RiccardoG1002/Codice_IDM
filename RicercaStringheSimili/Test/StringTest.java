import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Confronto.ListaParoleSimili;

public class StringTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Riccardo Gallelli\\Desktop\\Nazioni.txt"));
		List<String> nazioni = new LinkedList<String>();
		
		String line = input.readLine();
		while (line != null) {
			nazioni.add(line);
			line = input.readLine();
		}
		
		List<String> paroleSimili = new LinkedList<String>();
		paroleSimili = ListaParoleSimili.paroleSimili("South", nazioni);
		
		System.out.println("Le parole trovate sono: ");
		for (String string : paroleSimili) {
			System.out.println(string);
		}
		
		input.close();
	}

}
