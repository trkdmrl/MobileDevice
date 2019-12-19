package com.demo.mobildevice.shared;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResMessage {

	private String message;
	
	private long id;
	
	public ResMessage(String message) {
		this.message = message;
	}
	
	public ResMessage(String message, long id) {
		this.message = message;
		this.id = id;
	}
	
}
