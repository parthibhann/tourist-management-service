package com.tourism.management.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tourism.management.service.entiry.Branch;
import com.tourism.management.service.entiry.Place;
import com.tourism.management.service.model.BranchDetail;
import com.tourism.management.service.util.Places;

@Component
public class TourismManagementMapper {
	
	public Branch branchDetailsToBranch(BranchDetail branchDetail) {
		Branch branch = new Branch();
		branch.setBranchName(branchDetail.getBranchName());
		branch.setWebsite(branchDetail.getWebsite());
		branch.setEmail(branchDetail.getEmail());
		branch.setContactNo(branchDetail.getContactNo());
		if(branchDetail.getPlaces()== null) {
			branch.setPlaces(addPlaces());
		}
		return branch;
	}
	
	public List<Place> addPlaces() {
		List<Place> placeList = new ArrayList<>();
		Place place = null;
		Places places[] = Places.values();
		for(Places iteratePlace :places) {
			place = new Place();
			place.setName(iteratePlace.toString());
			place.setRate(iteratePlace.getTariff());
			placeList.add(place);			
		}	
		return placeList;		
	}

}
