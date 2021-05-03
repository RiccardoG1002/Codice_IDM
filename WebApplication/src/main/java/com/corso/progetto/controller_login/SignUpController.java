package com.corso.progetto.controller_login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corso.dao.UserDAO;
import com.corso.dao.UserDAOmanage;
import com.corso.dto.User;

@Controller
public class SignUpController {
	
	private final int PASSWORD_MIN_LENGTH = 5;
	
	@GetMapping(value="/signUp")
	public String goToSignUp(HttpServletResponse response) throws IOException{
		return "signUp";
	}
	
	@PostMapping(value="/signUpCreate")
	public String createUser(@RequestParam(value="username") String username,
								@RequestParam(value="password") String password,
									@RequestParam(value="confirm_password") String confirmPassword,
										Model model,
											HttpServletRequest request) {
				
		model.addAttribute("isSearching", false);
		String errorMsg = null;
		String successfulMsg = null;
		
		User user = new User(username, password);
		UserDAO uDAO = new UserDAOmanage();
		
		HttpSession session = request.getSession();
		// controlla se è già presente un utente con lo stesso username
		if(!uDAO.ifExistUsername(user)) {
			
			// controlla se le password inserite coincidono
			if(!password.equals(confirmPassword)) {
				// password e password di conferma non corrispondono
				errorMsg = "La conferma della password non corrisponde con la password";	
				model.addAttribute("message", errorMsg);
				model.addAttribute("failLogin", "Riprova");
				return "search";
			} else if(user.getPassword().length() < PASSWORD_MIN_LENGTH){
				errorMsg = "La password deve avere almeno 6 caratteri";	
				model.addAttribute("message", errorMsg);
				model.addAttribute("failLogin", "Riprova");
				return "search";
			} else {
				// aggiunta dell'utente
				uDAO.addUser(user);
				session.setAttribute("isLogged", true);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60 * 3);
				String okMessage = "Benvenuto " + user.getUsername();
				model.addAttribute("messageSuccessful", okMessage);
				return "search";
			}
		} else {
			// account già presente -> rimanda alla pagina di creazione account
			errorMsg = "'"+user.getUsername() + "' è già in uso, cambia il nome utente e riprova!";	
			model.addAttribute("message", errorMsg);
			model.addAttribute("failLogin", "Registrati");
			return "search";
		}		
	}
	
	@PostMapping(value="/changePsw")
	public String changePsw(@RequestParam(value="username") String username,
								@RequestParam(value="password") String password,
									@RequestParam(value="confirm_password") String confirmPassword,
										Model model,
											HttpServletRequest request) {
				
		model.addAttribute("isSearching", false);
		String errorMsg = null;
		String successfulMsg = null;
		
		User user = new User(username, password);
		UserDAO uDAO = new UserDAOmanage();

		HttpSession session = request.getSession();
		// controlla se è già presente un utente con lo stesso username
		if(uDAO.ifExistUsername(user)) { // controlla se le password inserite coincidono
			if(!password.equals(confirmPassword)) { // password e password di conferma non corrispondono
				errorMsg = "La conferma della password non corrisponde alla password inserita";	
				model.addAttribute("message", errorMsg);
				return "search";
			} else if(user.getPassword().length() < PASSWORD_MIN_LENGTH){
				errorMsg = "La password deve avere almeno 6 caratteri";	
				model.addAttribute("message", errorMsg);
				return "search";
			} else {
				// modifica della psw
				user.setPassword(password);
				uDAO.setNewPassword(user.getUsername(),user.getPassword());
				session.setAttribute("isLogged", true);
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60 * 3);
				successfulMsg = "La tua password è stata cambiata correttamente!"; 
				model.addAttribute("messageSuccessful", successfulMsg);
				return "search";
			}
		} else {
			// account già presente -> rimanda alla pagina di creazione account
			errorMsg = "L'utente " +user.getUsername() + " non esiste.";	
			model.addAttribute("message", errorMsg);
			model.addAttribute("fail", "Registrati");
			return "search";
		}		
	}
}
