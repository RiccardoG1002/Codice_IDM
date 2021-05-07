package com.corso.progetto.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
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
			@RequestParam(value="approved", required=false) List<String> approvedList,
			@RequestParam(value="removed", required=false) List<String> deleteList, 
			HttpServletRequest request) throws IOException {
		
		

		model.addAttribute("isSearching", false);
		ClassPathXmlApplicationContext contextDAOs = new ClassPathXmlApplicationContext("daos.xml");

		PatternDAO pDAO = (PatternDAO) contextDAOs.getBean("patternDAO");
		if(approvedList != null) {
			for(String userPattern: approvedList) {
				pDAO.setApprove(userPattern, 1);
			}
		}
		
		if(deleteList != null) {
			for(String userPattern: deleteList) {
				pDAO.deletePattern(userPattern);
			}
		}
		
		Enumeration<String> a = request.getParameterNames();
		while (a.asIterator().hasNext()) {
			String s = a.asIterator().next();
			if(s.contains("selected")) {
				//System.out.println(s + " " + request.getParameter(s));
				String s2 = s.replaceAll("_selected", "");
			    pDAO.updateCountry(s2,request.getParameter(s));
			}
		}

		return "redirect:" + "http://localhost:8080/WebApplication/approve";
	}
}