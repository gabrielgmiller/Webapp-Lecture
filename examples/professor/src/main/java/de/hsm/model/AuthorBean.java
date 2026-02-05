package de.hsm.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	public AuthorBean(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AuthorBean() {
	}

	public String getName() {
		return firstName + " " + lastName;
	}
	
}
