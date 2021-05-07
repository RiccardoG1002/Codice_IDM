package com.corso.checkstring.algorithms;

import java.util.Collection;
import java.util.stream.Collectors;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

public abstract class CountryAlgorithm<T> {
	private CountryAlgorithm<?> next = null;

	
	public void setNext(CountryAlgorithm<?> next) {
		this.next = next;
	}
	
	protected CountryAlgorithm<?> getNext() {
		return next;
	}
	
	protected abstract T checkString(String string, Collection<String> collection);
	
	public final Country getMostSimilarCountry(String input) {
		
		if(input.equals(""))
			return null;		
		
	//	if (collection == null) {
		Collection<String> collection = null;
		CountryDAO cDAO = new CountryDAOImpl();
		collection = cDAO.getColumnFromTable("name");
		input = input.toLowerCase();
		collection = collection.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
//		}
		
		
		T res = checkString(input, collection);
		
		if (res != null) {
			
			if(res instanceof Country)
				return (Country) res;
			
			else if(res instanceof Match)
				return addNewPattern(input, (Match) res);
		}
			
		if (next != null)
			return next.getMostSimilarCountry(input);
	
		return null;
	} 
	
	private Country addNewPattern(String find,Match match) {
		Country c = null;
		
		CountryDAO cDAO = new CountryDAOImpl();
		PatternDAO pDAO = new PatternDAOImpl();
		

		System.out.println(match.toString());
		
		c = cDAO.getCountryByName(match.getMatch());
		
		if (match.getDistance() ==0)
			c.setFromApprovedSource(true);
		
		Pattern dto = new Pattern(find, c, match.getAlgorithm().toString(), c.isFromApprovedSource()? 1:0);
		pDAO.save(dto);
	
		return c;
	}
	
	

}
