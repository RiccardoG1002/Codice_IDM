package com.corso.progetto.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public ModelAndView home(HttpServletResponse response, Model model) throws IOException {
		return new ModelAndView("search");
	}
}