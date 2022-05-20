package com.app.Validations;

public class Validator {
	
	public boolean doesPasswordAndConfirmPasswordMatch(String password, String confirmPassword) {
		if(password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}

}
