package com.corso.dizionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class DizionarioDaLocale implements Dizionario {

	public Collection<String> getParoleStd() {
		
		ArrayList<String> countries = new ArrayList();
		 for (String countryCode : Locale.getISOCountries()) {

		   Locale obj = new Locale("", countryCode);
		   countries.add(obj.getDisplayCountry());

		 }
		 
		 return countries;
	}

}
