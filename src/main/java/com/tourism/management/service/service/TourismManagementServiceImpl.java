package com.tourism.management.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.management.service.entiry.Branch;
import com.tourism.management.service.mapper.TourismManagementMapper;
import com.tourism.management.service.model.BranchDetail;
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
	public String addPlaces(BranchDetail branchDetail) {
	
		log.debug(" Entering addPlaces ");
		Branch branch = tourismManagementMapper.branchDetailsToBranch(branchDetail);
		
		Branch branchResponse = tourismManagementRepo.insert(branch);
		return branchResponse.toString();
	}

	@Override
	public String updateTariff(BranchDetail branchDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
