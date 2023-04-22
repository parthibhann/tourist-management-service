package com.tourism.management.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.management.service.entiry.Branch;

@Repository
public interface TourismManagementRepository extends MongoRepository<Branch, String> {

	@Query("{branchName:'?0'}")
	Branch findByBranchName(String branchName);
	
}
