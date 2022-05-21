package com.laptrinhjavaweb.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.ABC.BuildingAbc;

import com.laptrinhjavaweb.model.buildingSearchInput;
import com.laptrinhjavaweb.model.buildingSearchOutput;
import com.laptrinhjavaweb.service.iBuildingService;

@Controller
public class BuildingApi {
	@Autowired
	private iBuildingService iservice;


	@RequestMapping(value = "/Api/building", method = RequestMethod.GET)
	public @ResponseBody List<buildingSearchOutput> findAll(
			@RequestParam(value = "names", required = false) String names,
			@RequestParam(value = "floorarea", required = false) Integer floorarea,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "ward", required = false) String ward,
			@RequestParam(value = "numberofbasement", required = false) Integer numberofbasement,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "districtName", required = false) String districtName,
			@RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "rentareato", required = false) Integer rentareato,
			@RequestParam(value = "rentareafrom", required = false) Integer rentareafrom,
			@RequestParam(value = "rentpriceto", required = false) Integer rentpriceto,
			@RequestParam(value = "rentpricefrom", required = false) Integer rentpricefrom,
			@RequestParam(value = "namemanager", required = false) String namemanager,
			@RequestParam(value = "phonemananger", required = false) String phonemananger) {
		buildingSearchInput results = new buildingSearchInput();
		List<buildingSearchOutput> out = new ArrayList<buildingSearchOutput>();
		results.setName(names);
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
		out = iservice.findBuilding(results);
		return out;
	}

	@RequestMapping(value = "/Api/building", method = RequestMethod.POST)
	public @ResponseBody BuildingAbc insertBuilding() {
		// @ResponseBody chuc nang chuyen doi sang Ison
		BuildingAbc results = new BuildingAbc();
		return results;
	}

	@RequestMapping(value = "/Api/building", method = RequestMethod.PUT)
	public @ResponseBody BuildingAbc updateBuildung() {
		// @ResponseBody chuc nang chuyen doi sang Ison
		BuildingAbc results = new BuildingAbc();
		return results;
	}

}
