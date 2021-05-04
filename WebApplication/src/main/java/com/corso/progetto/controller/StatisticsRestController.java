package com.corso.progetto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.corso.checkstring.beans.StatAlgoritmo;
import com.corso.checkstring.dao.StatAlgoritmoDAO;
import com.corso.checkstring.dao.StatAlgoritmoDAOImpl;

@RestController
public class StatisticsRestController {
	
	@RequestMapping("/chart")
	@ResponseBody
		public List<StatAlgoritmo> getAllProducts() {
	
			StatAlgoritmoDAO dao = new StatAlgoritmoDAOImpl();
			
			List<StatAlgoritmo> lista =  dao.getStatsAlgoritmi();
			System.out.println(lista.toString());
			return lista;		
	}

}
