package com.corso.progetto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.corso.checkstring.beans.StatAlgoritmo;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;
import com.corso.checkstring.dao.StatAlgoritmoDAO;
import com.corso.checkstring.dao.StatAlgoritmoDAOImpl;

@Controller
public class StatisticsController {

	@GetMapping(value="/statistics")
	public String home(Model model) throws IOException {
		
		model.addAttribute("isSearching", false);
		ClassPathXmlApplicationContext contextDAOs = new ClassPathXmlApplicationContext("daos.xml");
		StatAlgoritmoDAO dao = (StatAlgoritmoDAO) contextDAOs.getBean("statAlgoDAO");
		
		List<StatAlgoritmo> lista =  dao.getStatsAlgoritmi();
		model.addAttribute("list", lista);
		
		
		return "statistics";
	}
}