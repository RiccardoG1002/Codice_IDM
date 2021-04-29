package com.corso.progetto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

@Controller
public class ApproveController {

	@GetMapping(value="/approve")
	public String home(Model model) throws IOException {
		
		PatternDAO pDAO = new PatternDAOImpl();
		CountryDAO cDao = new CountryDAOImpl();
		
		List<Pattern> patternList = pDAO.getPatternsToBeApproved();
		List<Country> countryList = cDao.getCountries();
		
		model.addAttribute("patternList", patternList);
		model.addAttribute("countryList", countryList);
		
		return "approve";
	}
}