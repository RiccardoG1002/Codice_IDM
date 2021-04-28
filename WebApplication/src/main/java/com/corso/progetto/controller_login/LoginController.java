package com.corso.progetto.controller_login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.corso.checkstring.beans.Pattern;
import com.corso.checkstring.dao.PatternDAO;
import com.corso.checkstring.dao.PatternDAOImpl;
import com.corso.dao.UserDAO;
import com.corso.dao.UserDAOmanage;
import com.corso.dto.User;


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
			// utente già loggato
			String failedMessage = "sei già in sessione " + userSession.getUsername();	
			model.addAttribute("message", failedMessage);
			/*if(userSession.getUsername().equals("admin")) {
				model.addAttribute("isAdmin", true);
			} else {
				model.addAttribute("isAdmin", false);
			}*/
			return "home";
			
		} else {
			User user = new User(username, password);
			UserDAO uDAO = new UserDAOmanage();
			
			if(uDAO.ifExistUser(user)) {
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60 * 3);
				String failedMessage = "bentornato " + user.getUsername();	
				model.addAttribute("message", failedMessage);
				
				if(user.getUsername().equals(adminName)) {
					session.setAttribute("isAdmin", true);
					model.addAttribute("isAdmin", true);
				} else {
					session.setAttribute("isAdmin", false);
					model.addAttribute("isAdmin", false);
				}
				return "search";
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
			
			String failedMessage = "è necessario autenticarsi";	
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
		
		return "search";
	}
	
	
	private String adminLogin() {
		return "admin";
	}
	
}
