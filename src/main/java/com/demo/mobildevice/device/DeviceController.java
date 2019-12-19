package com.demo.mobildevice.device;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mobildevice.error.ApiError;
import com.demo.mobildevice.shared.ResMessage;

@RestController
@RequestMapping("/restapi/v1")
public class DeviceController {

	@Autowired
	DeviceService deviceService;
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@PostMapping("/devices")
	ResMessage createDevice(@Valid @RequestBody Device device) {
		Device dev = deviceService.save(device);
		if(dev != null) {
		    return new ResMessage("Device saved!",dev.getId());
		}
		return new ResMessage("Can not multiple entries with same brand,model and osVersion!");
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ApiError handleValidationException(MethodArgumentNotValidException exception,HttpServletRequest request) {
		ApiError apiError = new ApiError(400, "Validation Error", request.getServletPath());
		
		BindingResult result = exception.getBindingResult();
		
		Map<String, String> validationErrors = new HashMap<>();
		
		for(FieldError fieldError : result.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		apiError.setValidationErrors(validationErrors);
		
		return apiError;
	}
	
}
