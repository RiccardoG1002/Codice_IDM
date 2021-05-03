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
		
		model.addAttribute("isSearching", false);
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			// utente già loggato
			String failedMessage = "sei già in sessione " + userSession.getUsername();	
			model.addAttribute("message", failedMessage);
		} else {
			User user = new User(username, password);
			UserDAO uDAO = new UserDAOmanage();
			
			if(uDAO.ifExistUsername(user)) {
				if(!uDAO.ifExistPassword(user)) {
					String message = "Password errata";	
					model.addAttribute("message", message);
					String fail = "Cambia password";	
					model.addAttribute("fail", fail);
				}else {
					session.setAttribute("isLogged", true);
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(60 * 3);
					String okMessage = "Bentornato " + user.getUsername();
					model.addAttribute("messageSuccessful", okMessage);
				}
				if(user.getUsername().equals(adminName)) {
					session.setAttribute("isAdmin", true);
				} else {
					session.setAttribute("isAdmin", false);
				}
			}else { //messaggio di errore per utente non registrato
				String message = "Il login è fallito.";	
				model.addAttribute("message", message);
				String fail = "Registrati";	
				model.addAttribute("failLogin", fail);
			}
			// messaggio di errore per psw dimenticata
		}
		return "search";
	}
	
	/*@RequestMapping(value="/approve")
	public String approve(Model model, HttpServletRequest request) {
		
		model.addAttribute("isSearching", false);
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
	}*/
	
	
	@RequestMapping(value="/logout")
	public String logout(Model model, HttpServletRequest request) {
		
		model.addAttribute("isSearching", false);
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		if(userSession != null) {
			session.setAttribute("isLogged", false);
			session.invalidate();
		
			String failedMessage = "hai fatto il log out";	
			model.addAttribute("message", failedMessage);
			
		} else {
			String failedMessage = "non sei in sessione";	
			model.addAttribute("message", failedMessage);
		}
		
		return "search";
	}
	
}
