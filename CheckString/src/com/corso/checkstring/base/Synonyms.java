package com.corso.checkstring.base;

import java.util.Collection;
import java.util.List;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
public class Synonyms {

	public Collection<Pattern> findSynonyms(Country country) {
		
//		CountryDAO cDAO = new CountryDAOImpl();
//		
//		Id id = new Id(country.getCode());
//		
//		List<Pattern> synonyms = cDAO.getPatternsFromCountryID(id);
//		
//		country.setPatternList(synonyms);
//		
//		System.out.println("lista dei sinonimi: " + synonyms);
		
		return country.getPatternList();
	}
}
