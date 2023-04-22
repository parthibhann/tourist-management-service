package com.tourism.management.service.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TourismManagementResponse {
	
	private BranchDetail branchDetail;
	private String status;
	private String satusText;
	private List<Messages> messages;

}
