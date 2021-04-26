package com.corso.checkstring.base;

import java.util.ArrayList;
import java.util.Locale;

import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.algorithms.Contains;
import com.corso.checkstring.algorithms.KMP;
import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.algorithms.Match;
import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

public class ControllerCheckString {

	public Country checkString(String find, Algorithm algo) {
		
		if(find.equals("")) {
			return null;
		}
		
		
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
			Match raw_result = algo.checkString(find, countryList);
			
			// inserisco in PatternDB o una coppia pattern-country o una pattern-null se non ho trovato un risultato
			Country c = null;
			String algorithm = null;
			
			if(raw_result != null) {
				String result = raw_result.getMatch();
				algorithm = raw_result.getAlgorithm();
				
				c = cDAO.getCountryByName(result);
			}
			
			Pattern dto = new Pattern(find, c, algorithm, 0);
			pDAO.save(dto);
			
			return c;
		}
	}
}
