package com.corso.progetto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.CountryDAO;
import com.corso.checkstring.dao.CountryDAOImpl;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

@Controller
public class ApproveController {

	@GetMapping(value="/approve")
	public String home(@RequestParam(value="page", required=false, defaultValue="0") int page, Model model) throws IOException {
		
		model.addAttribute("isSearching", false);
		
		ClassPathXmlApplicationContext contextDAOs = new ClassPathXmlApplicationContext("daos.xml");
		
		PatternDAO pDAO = (PatternDAO) contextDAOs.getBean("patternDAO");
		CountryDAO cDao = (CountryDAO) contextDAOs.getBean("countryDAO");
		
		List<Pattern> patternList = pDAO.getPatternsToBeApproved(page);
		List<Country> countryList = cDao.getCountries();
		
		model.addAttribute("patternList", patternList);
		model.addAttribute("countryList", countryList);
		
		return "approve";
	}
}