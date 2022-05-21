package com.laptrinhjavaweb.Utils;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.model.buildingSearchInput;

@Component
public class StringSql {
	public String toSql(buildingSearchInput input) {
		StringBuilder sql = new StringBuilder(
				"select * from building inner JOIN rentarea ON building.id = rentarea.buildingid inner join district On building.districtid = district.id");
		sql.append(" where 1 = 1");
		if (input.getName() != null & input.getName().isEmpty()) {
			sql.append(" and building.name like '%" + input.getName() + "%'");
		}

		if (input.getFloorarea() != null) {
			sql.append(" and floorarea = " + input.getName() + " ");
		}
		if (input.getStreet() != null & input.getStreet().isEmpty()) {
			sql.append(" and  street like '%" + input.getStreet() + " %'");
		}
		if (input.getWard() != null & input.getWard().isEmpty()) {
			sql.append(" and  ward like '%" + input.getWard() + "%'");
		}

		if (input.getDistrictname() != null & input.getDistrictname().isEmpty()) {
			sql.append(" and  district.name like '%" + input.getDistrictname() + "%'");
		}

		if (input.getNumberofbasement() != null) {
			sql.append(" and  numberofbasement = " + input.getDistrictname() + "");
		}
		if (input.getDirection() != null & input.getDirection().isEmpty()) {
			sql.append(" and  direction like '%" + input.getDirection() + "%'");
		}
		if (input.getLevel() != null & input.getLevel().isEmpty()) {
			sql.append(" and  level like '%" + input.getLevel() + "%'");
		}
		if (input.getNamemanager() != null & input.getNamemanager().isEmpty()) {
			sql.append(" and  namemanager like '%" + input.getNamemanager() + "%'");
		}
		if (input.getPhonemananger() != null & input.getPhonemananger().isEmpty()) {
			sql.append(" and  phonemanager like '%" + input.getPhonemananger() + "%'");
		}
		if (input.getRentareato() != null & input.getRentareafrom() != null) {
			sql.append(
					" and rentarea.value between " + input.getRentareato() + " and " + input.getRentareafrom() + " ");
		}
		if (input.getRentareato() != null & input.getRentareafrom() == null) {
			sql.append(" and rentarea.value >= " + input.getRentareato() + "  ");
		}
		if (input.getRentareato() == null & input.getRentareafrom() != null) {
			sql.append(" and rentarea.value <= " + input.getRentareafrom() + "  ");
		}
		if (input.getRentpriceto() != null & input.getRentpricefrom() != null) {
			sql.append(" and rentprice between " + input.getRentpriceto() + " and " + input.getRentpricefrom() + " ");
		}
		if (input.getRentareato() != null & input.getRentpricefrom() == null) {
			sql.append(" and rentprice >= " + input.getRentpriceto() + "  ");
		}
		if (input.getRentareato() == null & input.getRentpricefrom() != null) {
			sql.append(" and rentprice <= " + input.getRentpricefrom() + "  ");
		}
		sql.append(" group by building.id  ");
		return sql.toString();
	}
	public String StringtoSql(String input) {
		StringBuilder sql= new StringBuilder();
		if (input != null & input.isEmpty()) {
			 sql.append( " and input like '%" + input+ "%'");	
		} 
		return sql.toString();
	}
}
