package com.demo.mobildevice.device;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OsOptionValidator implements ConstraintValidator<OsOption, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value.equals("iOS") || value.equals("Android")) {
		     return true;
		}
		return false;
	}	
}
