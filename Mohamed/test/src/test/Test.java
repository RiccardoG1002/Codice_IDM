package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dipendente d1 = new Dipendente(9,"A");
		Dipendente d2 = new Dipendente(90,"B");
		Dipendente d3 = new Dipendente(905,"BA");
		Dipendente d4 = new Dipendente(90000.0,"BH");
		
		List<Dipendente> lista = new ArrayList<>();
		lista.add(d1);
		lista.add(d2);
		lista.add(d3);
		lista.add(d4);
		
		
		lista = lista.stream().filter(x -> x.getSalario() > 35).collect(Collectors.toList());
		
		for(Dipendente d : lista)
			System.out.println(d.getNome());

	}

}
