package com.tourism.management.service.util;

import java.util.ArrayList;

import com.tourism.management.service.model.Messages;
import com.tourism.management.service.model.TourismManagementResponse;

public class TourismManagementServiceHelper {
	
	private TourismManagementServiceHelper() {}
	
	public static TourismManagementResponse createTourismManagementResponse(String status, String text) {
		
		TourismManagementResponse tourismManagementResponse = new TourismManagementResponse();
		tourismManagementResponse.setStatus(status);
		tourismManagementResponse.setSatusText(text);
		return tourismManagementResponse;
	}
	
	public static TourismManagementResponse createTourismManagementResponse(String status, String text, String type, String... messages) {
		
		TourismManagementResponse tourismManagementResponse = createTourismManagementResponse(status, text);
		for(String message: messages) {
			if(tourismManagementResponse.getMessages() == null) {
				tourismManagementResponse.setMessages(new ArrayList<>());
			}
			tourismManagementResponse.getMessages().add(prepareMessage(type, message));
		}
		return tourismManagementResponse;
	}
	
	private static Messages prepareMessage(String type, String message) {
		Messages messages = new Messages();
		messages.setType(type);
		messages.setMessage(message);
		return messages;
	}

}
