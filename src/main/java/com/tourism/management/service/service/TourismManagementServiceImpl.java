package com.tourism.management.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.management.service.config.TourismManagementServiceException;
import com.tourism.management.service.entiry.Branch;
import com.tourism.management.service.mapper.TourismManagementMapper;
import com.tourism.management.service.model.TourismManagementRequest;
import com.tourism.management.service.model.TourismManagementResponse;
import com.tourism.management.service.repository.TourismManagementRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TourismManagementServiceImpl implements TourismManagementService {

	@Autowired
	TourismManagementMapper tourismManagementMapper;
	
	@Autowired
	TourismManagementRepository tourismManagementRepo;
	
	@Override
	public TourismManagementResponse addPlaces(TourismManagementRequest tourismManagementRequest) {
	
		log.debug(" Entering addPlaces ");
		Branch branch = tourismManagementMapper.branchDetailsToBranch(tourismManagementRequest.getBranchDetail());
		
		TourismManagementResponse tourismManagementResponse = null;
		
		if(tourismManagementRepo.findByBranchName(branch.getBranchName()) != null) {
			Branch branchResponse = tourismManagementRepo.save(branch);
			tourismManagementResponse = tourismManagementMapper.prepareBranchDetails(branchResponse);
			tourismManagementResponse.setStatus("SUCCESS");
			tourismManagementResponse.setSatusText("Branch Saved Successfully");
		}
		
		return tourismManagementResponse;
	}

	@Override
	public TourismManagementResponse updateTariff(TourismManagementRequest tourismManagementRequest) {
		log.debug("updateTariff");
		Branch branch = tourismManagementMapper.branchDetailsToBranch(tourismManagementRequest.getBranchDetail());
		
		TourismManagementResponse tourismManagementResponse = null;
		
		Optional<Branch> branchO = tourismManagementRepo.findById(branch.getBranchId());
		
		if (branchO.isEmpty()) {
			throw new TourismManagementServiceException("NO Data found for the ID provided Please check the ID");
		}
		
		Branch branchResponse = tourismManagementRepo.save(branch);
		tourismManagementResponse = tourismManagementMapper.prepareBranchDetails(branchResponse);
		tourismManagementResponse.setStatus("SUCCESS");
		tourismManagementResponse.setSatusText("Tariff updated Successfully");
		
		return tourismManagementResponse;
	}

}
