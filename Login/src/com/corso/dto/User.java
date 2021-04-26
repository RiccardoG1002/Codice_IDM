package com.corso.dto;

public class User implements DTO{
	
	private String username;
	private String password;
	private String risposta;
	
	public User() {}
	
	public User(String type, String password) {
		this.username = type;
		this.password = password;
	}
	
	public User(String type, String password, String risposta) {
		this.username = type;
		this.password = password;
		this.risposta = risposta;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	

}
