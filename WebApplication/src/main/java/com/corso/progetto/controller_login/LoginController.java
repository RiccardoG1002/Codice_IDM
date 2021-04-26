package com.corso.progetto.controller_login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;

import dao.UserDAO;
import dao.UserDAOmanage;
import dto.User;


@Controller
public class LoginController {

	private String adminName = "admin";
	
	@RequestMapping(value="/login")
	public String test(@RequestParam(value="username") String username,
						@RequestParam(value="password") String password,
						 Model model,
						 	 HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			// utente gi� loggato
			String failedMessage = "sei gi� in sessione " + userSession.getUsername();	
			model.addAttribute("message", failedMessage);
			return "home";
		} else {
			User user = new User(username, password);
			UserDAO uDAO = new UserDAOmanage();
			
			if(uDAO.ifExistUser(user)) {
				if(user.getUsername().equals(adminName)) {
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(60 * 3);
					String failedMessage = "bentornato " + user.getUsername();	
					model.addAttribute("message", failedMessage);
					return "home";
				} else {
					return "user";
				}
			} 
			
			// messaggio di errore
			String failedMessage = "login failed";	
			model.addAttribute("message", failedMessage);
		}
		return "index";
	}
	
	
	
	@RequestMapping(value="/approve")
	public String approve(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			PatternDAO pDAO = new PatternDAOImpl();
			List<Pattern> patternList = pDAO.getPatternsToBeApproved();
			
			model.addAttribute("patternList", patternList);
			
			return "approve";
		} else {				
			// messaggio di errore
			
			String failedMessage = "� necessario autenticarsi";	
			model.addAttribute("message", failedMessage);
			
			return "index";
		}
		
	}
	
	
	@RequestMapping(value="/logout")
	public String logout(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			session.invalidate();
		
			String failedMessage = "hai fatto il log out";	
			model.addAttribute("message", failedMessage);
			
		} else {
			String failedMessage = "non sei in sessione";	
			model.addAttribute("message", failedMessage);
		}
		
		return "home";
	}
	
	
	
	
}