package com.corso.progetto.controller_login;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.UserDAO;
import dao.UserDAOmanage;
import dto.User;

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
										Model model) {
				
		String errorMsg = null;
		String successfulMsg = null;
		
		User user = new User(username, password);
		UserDAO uDAO = new UserDAOmanage();
		
		
		// controlla se è già presente un utente con lo stesso username
		if(!uDAO.ifExistUsername(user)) {
			
			// controlla se le password inserite coincidono
			if(!password.equals(confirmPassword)) {
				// password e password di conferma non corrispondono
				errorMsg = "The confirm password doesn't match with password";	
				model.addAttribute("message", errorMsg);
				return "signUp";
			} else if(user.getPassword().length() < PASSWORD_MIN_LENGTH){
				errorMsg = "Your password must have at least 6 characters";	
				model.addAttribute("message", errorMsg);
				return "signUp";
			} else {
				// aggiunta dell'utente
				uDAO.addUser(user);
				successfulMsg = "Your account has been created successfully!"; 
				model.addAttribute("messageSuccessful", successfulMsg);
				return "index";
			}
			
			
		} else {
			// account già presente -> rimanda alla pagine di creazione account
			errorMsg = user.getUsername() + " is already used! Try again with other username";	
			model.addAttribute("message", errorMsg);
			return "signUp";
		}
		
		
	}
}
