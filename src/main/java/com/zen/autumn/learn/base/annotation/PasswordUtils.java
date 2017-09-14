package com.zen.autumn.learn.base.annotation;

import java.util.List;

public class PasswordUtils {

	
	@UseCase(id = 47,description = "lll")
	public boolean validatePsd(String psd){
		return psd.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id = 48)
	public String encryptPsd(String psd){
		return new StringBuilder(psd).reverse().toString();
	}
	
	@UseCase(id = 49,description = "repeat")
	public boolean checkForNewPsd(List<String> prevPsds,String psd){
		return !prevPsds.contains(psd);
	}
	
}
