package com.corso.checkstring.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;

public interface CountryDAO {

	public String save(Country dto);
	public ArrayList<String> getColumnFromTable(String field);
	public boolean isEmpty();
	public Country getCountryByName(Serializable name);
	public List<Pattern> getPatternsFromCountryID(Id id);
	public List<Country> getCountries();
	public Country getCountry(String code);
}
