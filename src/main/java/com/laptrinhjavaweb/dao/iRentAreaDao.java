package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.dao.entity.rentareaEntity;


public interface iRentAreaDao {
	List<rentareaEntity> findBuildingid(Long id);
}
