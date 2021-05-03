package com.corso.checkstring.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

public class CheckDatabase extends Algorithm<Country> {

	@Override
	protected Country checkString(String string, Collection<String> collection) {
		
		PatternDAO pDAO = new PatternDAOImpl();
		
		// poplare il DB se è vuoto 
		// checkAndPopulateDB(cDAO);
		
		Pattern alreadyInDB = pDAO.get(new Id(string));
		
		if(alreadyInDB != null) {
			// abbiamo trovato il pattern nel PatternDB
			System.out.println("Ho trovato la soluzione nel PatternDB!");
			
			if(alreadyInDB.getApproved() == 0) {
				
			 alreadyInDB.getCountry().setFromApprovedSource(false);
			 return alreadyInDB.getCountry();
			}
			
			return alreadyInDB.getCountry();
		}
		return null;
	}
	
	
	private void checkAndPopulateDB(CountryDAO cDAO) {
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
	}
}
