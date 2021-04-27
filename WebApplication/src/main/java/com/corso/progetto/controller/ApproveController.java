package com.corso.progetto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

@Controller
public class ApproveController {

	@GetMapping(value="/approve")
	public String home(Model model) throws IOException {
		
		PatternDAO pDAO = new PatternDAOImpl();
		List<Pattern> patternList = pDAO.getPatternsToBeApproved();
		
		model.addAttribute("patternList", patternList);
		
		return "approve";
	}
}