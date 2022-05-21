package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Converter.Converter;
import com.laptrinhjavaweb.dao.iBuildingDAO;
import com.laptrinhjavaweb.dao.iDistrictDao;
import com.laptrinhjavaweb.dao.iRentAreaDao;
import com.laptrinhjavaweb.dao.entity.BuildingEntity;
import com.laptrinhjavaweb.dao.entity.districtEntity;
import com.laptrinhjavaweb.dao.entity.rentareaEntity;
import com.laptrinhjavaweb.dao.impl.buildingDaoImpl;
import com.laptrinhjavaweb.dao.impl.districtDaoImpl;
import com.laptrinhjavaweb.dao.impl.rentAreaDaoImpl;
import com.laptrinhjavaweb.model.buildingSearchInput;
import com.laptrinhjavaweb.model.buildingSearchOutput;
import com.laptrinhjavaweb.service.iBuildingService;


@Service
public class buildingServiceImpl implements iBuildingService {
	
	@Autowired
	private iBuildingDAO buildingDao = new buildingDaoImpl();
	
	@Autowired
	private iRentAreaDao rentareaDao = new rentAreaDaoImpl();
	
	@Autowired
	private iDistrictDao districtDao = new districtDaoImpl();

	@Autowired
	private Converter converter;
	
	@Override
	public List<buildingSearchOutput> findBuilding(buildingSearchInput input) {
		List<buildingSearchOutput> Output = new ArrayList<buildingSearchOutput>();
		List<BuildingEntity> entity = buildingDao.findBuilding(input);
		for (BuildingEntity item : entity) {
			buildingSearchOutput results = new buildingSearchOutput();
			List<rentareaEntity> rentareaEntity = rentareaDao.findBuildingid(item.getId());
			districtEntity district = districtDao.findDistrictId(item.getDistrictid());
			results = converter.toDTO(item);
			results.setAddress(item.getStreet() + "," + item.getWard() + "," + district.getName());
			results.setAreaempty(converter.ValuetoString(rentareaEntity));
			Output.add(results);
		}
		return Output;
	}

}
