package com.tourism.management.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tourism.management.service.entiry.Branch;

public interface TourismManagementRepository extends MongoRepository<Branch, Integer> {

}
