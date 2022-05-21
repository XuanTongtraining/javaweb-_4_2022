package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.dao.entity.BuildingEntity;
import com.laptrinhjavaweb.model.buildingSearchInput;

public interface iBuildingDAO {
	List<BuildingEntity> findBuilding(buildingSearchInput input);
}
