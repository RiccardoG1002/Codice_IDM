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

	@SuppressWarnings("resource")
	@GetMapping(value = "/results")
	public String showResults(@RequestParam("find") String find, Model model)
			throws IOException {

		ControllerCheckString c = new ControllerCheckString();
		Algorithm algorithm = (Algorithm) new ClassPathXmlApplicationContext("algorithms.xml").getBean("checkString");
		Country country = c.checkString(find, algorithm);

		String message = null;
		String ret = "";

		if (country != null) {
			model.addAttribute("isSearching", true);
			model.addAttribute("country", country);
			ret = "results";
		} else {
			message = "Il paese " + find + " non ha sinonimi!";
			System.out.println("Il paese " + find + " non ha sinonimi!");
			model.addAttribute("message", message);
			ret = "search";
		}
		return ret;
	}
}