package com.corso.checkstring.beans;

import java.io.Serializable;

public class Id implements Serializable {

	private Serializable id;

	public Id(String find) {
		
		this.id = find;
	}

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}
}
