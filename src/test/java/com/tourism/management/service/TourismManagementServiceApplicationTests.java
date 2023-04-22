package com.tourism.management.service;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourism.management.service.model.BranchDetail;
import com.tourism.management.service.model.Place;
import com.tourism.management.service.model.TourismManagementRequest;

//@SpringBootTest
class TourismManagementServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void populateTourismManagementRequest() throws JsonProcessingException, DatatypeConfigurationException {
		
		TourismManagementRequest tourismManagementRequest = new TourismManagementRequest();
		
		BranchDetail branchDetail = new BranchDetail();
		branchDetail.setBranchName("Dubai");
		branchDetail.setWebsite("dubaiwebsite.com");
		branchDetail.setEmail("dubaimainroad@dubai.com");
		branchDetail.setContactNo(1235486970);

	    List<Place> places = List.of(new Place("ANDAMAN",50000 ), new Place("THAILAND",60000 ), new Place("DUBAI",70000 ), new Place("SINGAPORE",80000 ), new Place("MALASIYA",90000 )); 
		branchDetail.setPlaces(places);
			
		tourismManagementRequest.setBranchDetail(branchDetail);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String output = objectMapper.writeValueAsString(tourismManagementRequest);
		
		System.out.println(output);
		
	}
	
}
