package com.tourism.management.service.service;

import com.tourism.management.service.model.TourismManagementRequest;
import com.tourism.management.service.model.TourismManagementResponse;

public interface TourismManagementService {
	
	public TourismManagementResponse addPlaces(TourismManagementRequest tourismManagementRequest);
	
	public TourismManagementResponse updateTariff(TourismManagementRequest tourismManagementRequest); 

}
