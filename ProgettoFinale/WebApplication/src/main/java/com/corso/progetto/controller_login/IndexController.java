package com.corso.progetto.controller_login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDAO;
import dao.UserDAOmanage;
import dto.User;

@Controller
public class IndexController {

	private User admin = new User("admin", "admin");
	
	@RequestMapping(value="/startLogin")
	public String test(HttpServletRequest request, Model model) {
		
		UserDAO uDAO = new UserDAOmanage();
		
		if(uDAO.isEmpty()){
			uDAO.addUser(admin);
		}
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			// utente già loggato
			String failedMessage = "sei già in sessione " + userSession.getUsername();	
			model.addAttribute("message", failedMessage);
			return "home";
		}
		
	
		return "index";
	}
}
