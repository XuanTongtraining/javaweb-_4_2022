package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.Utils.StringSql;
import com.laptrinhjavaweb.dao.iBuildingDAO;
import com.laptrinhjavaweb.dao.entity.BuildingEntity;
import com.laptrinhjavaweb.model.buildingSearchInput;

@Repository
public class buildingDaoImpl implements iBuildingDAO {

	private final String DB_URL = "jdbc:mysql://localhost/databaseweb";
	private final String USER = "root";
	private final String PASS = "12345678";

	public List<BuildingEntity> findBuilding(buildingSearchInput input) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		StringSql util = new StringSql();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// load driver Connection conn
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder(
					"select * from building inner JOIN rentarea ON building.id = rentarea.buildingid inner join district On building.districtid = district.id");
			sql.append(" where 1 = 1");

			if (input.getName() != null) {
				sql.append(" and building.name like '%" + input.getName() + "%'");
			}
			if (input.getFloorarea() != null) {
				sql.append(" and floorarea = " + input.getFloorarea() + " ");
			}

			if (input.getStreet() != null) {
				sql.append(" and  street like '%" + input.getStreet() + " %'");
			}
			if (input.getWard() != null) {
				sql.append(" and  ward like '%" + input.getWard() + "%'");
			}

			if (input.getDistrictname() != null) {
				sql.append(" and  district.name like '%" + input.getDistrictname() + "%'");
			}

			if (input.getNumberofbasement() != null) {
				sql.append(" and  numberofbasement = " + input.getDistrictname() + "");
			}
			if (input.getDirection() != null) {
				sql.append(" and  direction like '%" + input.getDirection() + "%'");
			}
			if (input.getLevel() != null) {
				sql.append(" and  level like '%" + input.getLevel() + "%'");
			}
			if (input.getNamemanager() != null & input.getNamemanager().isEmpty()) {
				sql.append(" and  namemanager like '%" + input.getNamemanager() + "%'");
			}
			if (input.getPhonemananger() != null) {
				sql.append(" and  phonemanager like '%" + input.getPhonemananger() + "%'");
			}
			if (input.getRentareato() != null & input.getRentareafrom() != null) {
				sql.append(" and rentarea.value between " + input.getRentareato() + " and " + input.getRentareafrom()
						+ " ");
			}
			if (input.getRentareato() != null & input.getRentareafrom() == null) {
				sql.append(" and rentarea.value >= " + input.getRentareato() + "  ");
			}
			if (input.getRentareato() == null & input.getRentareafrom() != null) {
				sql.append(" and rentarea.value <= " + input.getRentareafrom() + "  ");
			}
			if (input.getRentpriceto() != null & input.getRentpricefrom() != null) {
				sql.append(
						" and rentprice between " + input.getRentpriceto() + " and " + input.getRentpricefrom() + " ");
			}
			if (input.getRentareato() != null & input.getRentpricefrom() == null) {
				sql.append(" and rentprice >= " + input.getRentpriceto() + "  ");
			}
			if (input.getRentareato() == null & input.getRentpricefrom() != null) {
				sql.append(" and rentprice <= " + input.getRentpricefrom() + "  ");
			}
			sql.append(" group by building.id ");
			// String sql = util.toSql(input);
			// String sql = "select * from building where name like'%"+input.getName()+"%'
			// and floorarea = "+input.getFloorarea()+" and street like
			// '%"+input.getStreet()+"%' "
			// + " and ward like '%"+input.getWard()+"%' and numberofbasement =
			// "+input.getNumberofbasement()+" " ;
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) { // Display values
				BuildingEntity entity = new BuildingEntity();
				entity.setId(rs.getLong("id"));
				entity.setName(rs.getString("name"));
				entity.setWard(rs.getString("ward"));
				entity.setDistrictid(rs.getLong("districtid"));
				entity.setStreet(rs.getString("street"));
				entity.setNamemanager(rs.getString("namemanager"));
				entity.setPhonemananger(rs.getString("phonemanager"));
				entity.setFloorarea(rs.getInt("floorarea"));
				entity.setRentprice(rs.getInt("rentprice"));
				entity.setServicefee(rs.getString("servicefee"));
				entity.setBrokeragefee(rs.getString("brokeragefee"));
				results.add(entity);
			}
			return results;
		} catch (SQLException | ClassNotFoundException | ArithmeticException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {

			}
		}
		return null;
	}

}
