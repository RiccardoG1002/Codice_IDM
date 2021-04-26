package com.corso.progetto.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.algorithms.Algorithm;
import com.corso.checkstring.beans.Country;


@Controller
public class ResultsController {

	@GetMapping(value="/results")
	public String showResults(@RequestParam("find") String find, Model model) throws IOException {
		
		 File curDir = new File("./.");
		getAllFiles(curDir);
		com.corso.checkstring.base.Controller c = new com.corso.checkstring.base.Controller();
		
		// get list of Algorithms from the beans file
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
	
	private static void getAllFiles(File curDir) {

	    File[] filesList = curDir.listFiles();
	    for(File f : filesList){
	        if(f.isDirectory())
	            System.out.println(f.getName());
	        if(f.isFile()){
	            System.out.println(f.getName());
	        }
	    }

	}
}
