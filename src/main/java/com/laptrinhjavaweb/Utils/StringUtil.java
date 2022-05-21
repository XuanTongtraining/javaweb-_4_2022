package com.laptrinhjavaweb.Utils;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.model.buildingSearchInput;

@Component
public class StringUtil {
	public buildingSearchInput StringUtils(String names, Integer floorarea, String street, String ward, 
			Integer numberofbasement, String direction,  String districtName, String level, Integer rentareato, 
			Integer rentareafrom, Integer rentpriceto, Integer rentpricefrom, String namemanager,String phonemananger) {
		
		buildingSearchInput results = new buildingSearchInput();
		/*results.setName(names);
		results.setFloorarea(floorarea);
		results.setStreet(street);
		results.setWard(ward);
		results.setNumberofbasement(numberofbasement);
		results.setDirection(direction);
		results.setDistrictname(districtName);
		results.setLevel(level);
		results.setRentareato(rentareato);
		results.setRentareafrom(rentareafrom);	
		results.setRentpriceto(rentpriceto);
		results.setRentpricefrom(rentpricefrom);
		results.setNamemanager(namemanager);
		results.setPhonemananger(phonemananger);*/
		if (names != null) {
			results.setName(names);
		}
		if (floorarea != null) {
			results.setFloorarea(floorarea);
		}
		if (street != null) {
			results.setStreet(street);
		}if (ward != null) {
			results.setWard(ward);
		
		}if (numberofbasement != null) {
			results.setNumberofbasement(numberofbasement);
		}if (direction != null) {
			results.setDirection(direction);
		}
		if (districtName != null) {
			results.setDistrictname(districtName);
		}
		if (level != null) {
			results.setLevel(level);
			
		}if (rentareato != null) {
			results.setRentareato(rentareato);
		
		}if (rentareafrom != null) {
			results.setRentareafrom(rentareafrom);	
		}		if (districtName != null) {
			results.setDistrictname(districtName);
		}
		if (rentpriceto != null) {
			results.setRentpriceto(rentpriceto);
			
		}if (rentpricefrom != null) {
			results.setRentpricefrom(rentpricefrom);
		
		}if (namemanager != null) {
			results.setNamemanager(namemanager);
			
		}if (phonemananger != null) {
			results.setPhonemananger(phonemananger);
			
		}
		return results;
		
	}

}
