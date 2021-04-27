package com.corso.progetto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
//		PatternDAO pDAO = new PatternDAOImpl();
//		
//		String algorithm1 = "Levenshtein";
//		String algorithm2 = "Contains";
//		
//		String count1 = pDAO.getAlgorithmSuccess(algorithm1);
//		String count2 = pDAO.getAlgorithmSuccess(algorithm2);
		StatAlgoritmoDAO dao = new StatAlgoritmoDAOImpl();
		
		List<StatAlgoritmo> lista =  dao.getStatsAlgoritmi();
		model.addAttribute("list", lista);
		
		//for (StatAlgoritmo s : lista)
		//	System.out.println(s.getAlgoritmo());
	//	model.addAttribute("count2", count2);
		
		return "statistics";
	}
}