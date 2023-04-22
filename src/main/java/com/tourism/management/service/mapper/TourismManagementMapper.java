package com.tourism.management.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tourism.management.service.entiry.Branch;
import com.tourism.management.service.entiry.Place;
import com.tourism.management.service.model.BranchDetail;
import com.tourism.management.service.model.TourismManagementResponse;

@Component
public class TourismManagementMapper {

	public Branch branchDetailsToBranch(BranchDetail branchDetail) {
		Branch branch = new Branch();
		branch.setBranchId(branchDetail.getBranchId());
		branch.setBranchName(branchDetail.getBranchName());
		branch.setWebsite(branchDetail.getWebsite());
		branch.setEmail(branchDetail.getEmail());
		branch.setContactNo(branchDetail.getContactNo());
		if (branchDetail.getPlaces() != null) {
			List<Place> places = branchDetail.getPlaces().stream()
					.map(place -> new Place(place.getName(), place.getRate())).collect(Collectors.toList());
			branch.setPlaces(places);
		}
		return branch;
	}

	public TourismManagementResponse prepareBranchDetails(Branch branchResponse) {
		TourismManagementResponse tourismManagementResponse = new TourismManagementResponse();
		BranchDetail branchDetail = new BranchDetail();
		branchDetail.setBranchId(branchResponse.getBranchId());
		branchDetail.setBranchName(branchResponse.getBranchName());
		branchDetail.setWebsite(branchResponse.getWebsite());
		branchDetail.setEmail(branchResponse.getEmail());
		branchDetail.setContactNo(branchResponse.getContactNo());
		if (branchResponse.getPlaces() != null) {
			List<com.tourism.management.service.model.Place> places = branchResponse.getPlaces().stream()
					.map(place -> new com.tourism.management.service.model.Place(place.getName(), place.getRate()))
					.collect(Collectors.toList());
			branchDetail.setPlaces(places);
		}
		tourismManagementResponse.setBranchDetail(branchDetail);
		return tourismManagementResponse;
	}

}
