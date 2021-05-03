package com.corso.progetto.controller;

import java.io.IOException;
import org.springframework.ui.Model;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.algorithms.CheckDatabase;
import com.corso.checkstring.algorithms.Levenshtein;
import com.corso.checkstring.algorithms.SoundEx;

import com.corso.checkstring.beans.Country;

@Controller
public class ResultsController {

	@SuppressWarnings("resource")
	@GetMapping(value = "/results")
	public String showResults(@RequestParam("find") String find, Model model)
			throws IOException {

		Algorithm algorithm = (Algorithm) new ClassPathXmlApplicationContext("algorithms.xml").getBean("checkString");
		
		Country country = algorithm.getMostSimilarCountry(find); 

		String message = null;
		String ret = "";

		if (country != null) {
			model.addAttribute("isSearching", true);
			model.addAttribute("country", country);
			
			if (!country.isFromApprovedSource())
				model.addAttribute("message", "Questo risultato non è stato ancora approvato");
			
			ret = "results";
		} else {
			message = "Paese " + find + " non trovato";
			model.addAttribute("message", message);
			ret = "search";
		}
	
		
		return "results";
	}
}