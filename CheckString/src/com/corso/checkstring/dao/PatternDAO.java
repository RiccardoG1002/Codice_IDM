package com.corso.checkstring.dao;

import java.util.List;

import com.corso.checkstring.beans.Id;
import com.corso.checkstring.beans.Pattern;

public interface PatternDAO {

	public String save(Pattern dto);
	public Pattern get(Id id);
	public Pattern[] getPendingPatterns();
	int setApprove(String userPattern, int approve);
	public int deletePattern(String userPattern);
	public int updateCountry(String userPattern, String newCountry);
	public List<Pattern> getPatternsToBeApproved();
	public String getAlgorithmSuccess(String algorithm);
}
