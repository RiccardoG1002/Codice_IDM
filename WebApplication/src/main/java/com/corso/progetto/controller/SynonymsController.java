package com.corso.progetto.controller;

import java.io.IOException;
import java.util.Collection;

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
public class SynonymsController {

	@SuppressWarnings("resource")
	@GetMapping(value = "/synonyms")
	public String showResults(@RequestParam("find") String find, Model model)
			throws IOException {

		ControllerCheckString c = new ControllerCheckString();
		Algorithm algorithm = (Algorithm) new ClassPathXmlApplicationContext("algorithms.xml").getBean("checkString");
		Country country = c.checkString(find, algorithm);

		String message = null;
		String ret = "";

		if (country != null) {
			Synonyms s = new Synonyms();
			Collection<Pattern> synonyms = s.findSynonyms(country);
			if (synonyms != null) {
				//System.out.println(synonyms);
				model.addAttribute("first",synonyms.iterator().next());
				model.addAttribute("synonyms", synonyms);
				ret = "synonyms";
			} else {
				message = "Il paese " + find + " non ha sinonimi!";
				System.out.println("Il paese " + find + " non ha sinonimi!");
				model.addAttribute("message", message);
				ret = "searchSynonyms";
			}
		
		} else {
			message = "Paese " + find + " non trovato!";
			model.addAttribute("message", message);
			ret = "searchSynonyms";
		}
		
		return ret;
	}
}