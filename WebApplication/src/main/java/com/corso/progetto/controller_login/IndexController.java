package com.corso.progetto.controller_login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.corso.dao.UserDAO;
import com.corso.dao.UserDAOmanage;
import com.corso.dto.User;

@Controller
public class IndexController {

	private User admin = new User("admin", "admin");
	
	@RequestMapping(value="/startLogin")
	public String test(HttpServletRequest request, Model model) {
		
		model.addAttribute("isSearching", false);
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
