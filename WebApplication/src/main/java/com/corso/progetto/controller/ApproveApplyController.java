package com.corso.progetto.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

@Controller
public class ApproveApplyController {

	@PostMapping(value="/apply")
	public String home(
			Model model,
			@RequestParam(value="approved", required=false) List<String> approvedList) throws IOException {
		
		if(approvedList != null) {
			PatternDAO pDAO = new PatternDAOImpl();
			
			for(String userPattern: approvedList) {
				pDAO.setApprove(userPattern, 1);
			}
		}

		return "redirect:" + "http://localhost:8080/WebApplication/approve";
	}
}