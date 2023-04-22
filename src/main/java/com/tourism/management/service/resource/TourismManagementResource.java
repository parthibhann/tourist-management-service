package com.tourism.management.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.management.service.model.TourismManagementRequest;
import com.tourism.management.service.model.TourismManagementResponse;
import com.tourism.management.service.service.TourismManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/manage")
@Slf4j
public class TourismManagementResource extends BaseResource {

	@Autowired
	TourismManagementService tourismManagementService;

	@PostMapping("places")
	public ResponseEntity<TourismManagementResponse> managePlaces(
			@Validated @RequestBody TourismManagementRequest tourismManagementRequest) {
		log.info("manageTourism - start");

		TourismManagementResponse tourismManagementResponse = tourismManagementService
				.addPlaces(tourismManagementRequest);

		return resolveResponse(tourismManagementResponse, HttpStatus.OK);
	}

	@PostMapping("tariff")
	public ResponseEntity<TourismManagementResponse> manageTariff(
			@Validated @RequestBody TourismManagementRequest tourismManagementRequest) {
		log.info("manageTariff - start");

		TourismManagementResponse tourismManagementResponse = tourismManagementService
				.updateTariff(tourismManagementRequest);

		return resolveResponse(tourismManagementResponse, HttpStatus.OK);
	}

}
