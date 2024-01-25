package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;

public class ErrorHandler {

	public Map<String, String> validacionInputs(BindingResult bindingResult) {
		
    	Map<String, String> errorsMap = new HashMap<>();
    	
    	//List<String> errors = new ArrayList();
    	
    	bindingResult.getFieldErrors().forEach((error)->{
    		String campo = error.getField();
    		String errorMsj = error.getDefaultMessage();    		
    		errorsMap.put(campo, errorMsj);    		
    		//error.add(errorMsj);
    	});
    	System.out.println(errorsMap);
    	return errorsMap;
	}
}
