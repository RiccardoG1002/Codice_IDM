package com.corso.checkstring.base;

import java.util.ArrayList;
import java.util.Locale;

import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.algorithms.Contains;
import com.corso.checkstring.algorithms.KMP;
import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

public class Controller {

	public Country checkString(String find) {
		
		if(find.equals("")) {
			return null;
		}
		
		Algorithm a1 = new Contains();
		Algorithm a2 = new Levenshtein();
		Algorithm a3 = new KMP();
		
		a1.setNext(a2);
		a2.setNext(a3);
		
		CountryDAO cDAO = new CountryDAOImpl();
		PatternDAO pDAO = new PatternDAOImpl();
		
		if(cDAO.isEmpty()) {
			// dobbiamo popolare il database
			String[] countryCodes = Locale.getISOCountries();
			
			for(String code: countryCodes) {
				Locale l = new Locale("", code);
				String name = l.getDisplayCountry();
				Country c = new Country(code, name);
				cDAO.save(c);
			}
		}
		
		ArrayList<String> countryList = cDAO.getColumnFromTable("name");
		
		Pattern alreadyInDB = pDAO.get(new Id(find));
		
		if(alreadyInDB != null) {
			// abbiamo trovato il pattern nel PatternDB
			System.out.println("Ho trovato la soluzione nel PatternDB!");
			
			if(alreadyInDB.getApproved() == 0) {
				return null;
			}
			
			return alreadyInDB.getCountry();
		}
		else {
			// dobbiamo cercare usando gli algoritmi
			String raw_result = a1.checkString(find, countryList);
			
			// inserisco in PatternDB o una coppia pattern-country o una pattern-null se non ho trovato un risultato
			Country c = null;
			String algorithm = null;
			
			if(raw_result != null) {
				String[] parts = raw_result.split(java.util.regex.Pattern.quote("$"));
				String result = parts[0];
				algorithm = parts[1];
				
				c = cDAO.getCountryByName(result);
			}
			
			Pattern dto = new Pattern(find, c, algorithm, 0);
			pDAO.save(dto);
			
			return c;
		}
	}
}
