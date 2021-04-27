package com.corso.progetto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.base.Synonyms;
import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.base.ControllerCheckString;
import com.corso.checkstring.beans.Country;
import com.corso.checkstring.beans.Pattern;

@Controller
public class ResultsController {

	@SuppressWarnings("resource")
	@GetMapping(value = "/results")
	public String showResults(@RequestParam("find") String find, @RequestParam("search") String search, Model model)
			throws IOException {

		ControllerCheckString c = new ControllerCheckString();
		Algorithm algorithm = (Algorithm) new ClassPathXmlApplicationContext("algorithms.xml").getBean("checkString");
		Country country = c.checkString(find, algorithm);

		String message = null;
		String ret = "";
		
		System.out.println(search);
		if (search.equals("search")) {
			if (country != null) {
				model.addAttribute("country", country);
				ret = "results";
			} else {
				message = "Paese " + find + " non trovato!";
				model.addAttribute("message", message);
				ret = "search";
			}
		} else if (search.equals("synonyms")) {
			if (country != null) {
				System.out.println("Il paese " + country.getCode() + " non ha sinonimi!");
				Synonyms s = new Synonyms();
				List<Pattern> synonyms = s.findSynonyms(country);
				if (synonyms != null) {
					System.out.println(synonyms);
					model.addAttribute("patterns", synonyms);
					ret = "results";
				} else {
					message = "Il paese " + find + " non ha sinonimi!";
					System.out.println("Il paese " + find + " non ha sinonimi!");
					model.addAttribute("message", message);
					ret = "search";
				}
			} else {
				message = "Paese " + find + " non trovato!";
				model.addAttribute("message", message);
				ret = "search";
			}
		}
		return ret;
	}
}