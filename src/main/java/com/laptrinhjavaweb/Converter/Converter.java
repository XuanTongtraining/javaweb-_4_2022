package com.laptrinhjavaweb.Converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dao.entity.BuildingEntity;
import com.laptrinhjavaweb.dao.entity.rentareaEntity;
import com.laptrinhjavaweb.model.buildingSearchOutput;

@Component
public class Converter {

	public buildingSearchOutput toDTO(BuildingEntity buildingEntity) {
		buildingSearchOutput dto = new buildingSearchOutput();
		dto.setName(buildingEntity.getName());
		dto.setNamemanager(buildingEntity.getNamemanager());
		dto.setPhonemananger(buildingEntity.getPhonemananger());
		dto.setFloorarea(buildingEntity.getFloorarea());
		dto.setRentprice(buildingEntity.getRentprice());
		dto.setServicefee(buildingEntity.getServicefee());
		dto.setBrokeragefee(buildingEntity.getBrokeragefee());
		return dto;
	}
	
	public String ValuetoString(List<rentareaEntity> rentarea) {
		StringBuilder emptyArea = new StringBuilder("");
		for (rentareaEntity item : rentarea) {
			emptyArea.append(item.getValue());
			emptyArea.append(", ");
		}
		return emptyArea.toString();
		
	}
	

}

