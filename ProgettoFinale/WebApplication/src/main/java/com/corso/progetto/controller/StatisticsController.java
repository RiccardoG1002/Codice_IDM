package com.corso.progetto.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

@Controller
public class StatisticsController {

	@GetMapping(value="/statistics")
	public String home(Model model) throws IOException {
		
		PatternDAO pDAO = new PatternDAOImpl();
		
		String algorithm1 = "Levenshtein";
		String algorithm2 = "Contains";
		
		String count1 = pDAO.getAlgorithmSuccess(algorithm1);
		String count2 = pDAO.getAlgorithmSuccess(algorithm2);
		
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		
		return "statistics";
	}
}