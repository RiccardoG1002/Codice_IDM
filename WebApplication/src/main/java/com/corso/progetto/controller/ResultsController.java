package com.corso.progetto.controller;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.base.ControllerCheckString;
import com.corso.checkstring.beans.Country;

@Controller
public class ResultsController {

	@GetMapping(value="/results")
	public String showResults(@RequestParam("find") String find, Model model) throws IOException {
		
		ControllerCheckString c = new ControllerCheckString();
		Algorithm algorithm = (Algorithm) new ClassPathXmlApplicationContext("algorithms.xml").getBean("checkString");
		Country country = c.checkString(find, algorithm);
		
		String message = null;
		
		if(country != null) {
			model.addAttribute("country", country);
			return "results";
		}
		else {
			message = "Paese " + find + " non trovato!";
			model.addAttribute("message", message);
			return "search";
		}
	}
}
