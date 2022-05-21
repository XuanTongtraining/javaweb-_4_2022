package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.buildingSearchInput;
import com.laptrinhjavaweb.model.buildingSearchOutput;

public interface iBuildingService {
	List<buildingSearchOutput> findBuilding(buildingSearchInput input);
}
