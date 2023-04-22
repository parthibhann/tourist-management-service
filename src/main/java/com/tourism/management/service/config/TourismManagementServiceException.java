package com.tourism.management.service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TourismManagementServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7481020899599828719L;

	public String message;
	
}
