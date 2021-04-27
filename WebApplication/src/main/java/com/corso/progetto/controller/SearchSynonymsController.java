package com.corso.progetto.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchSynonymsController {

	@GetMapping(value="/searchSynonyms")
	public ModelAndView search(HttpServletResponse response) throws IOException {
		return new ModelAndView("searchSynonyms");
	}
}
