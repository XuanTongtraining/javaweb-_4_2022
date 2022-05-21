package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.iRentAreaDao;
import com.laptrinhjavaweb.dao.entity.rentareaEntity;

@Repository
public class rentAreaDaoImpl implements iRentAreaDao{
	private final String DB_URL = "jdbc:mysql://localhost/databaseweb";
	private final String USER = "root";
	private final String PASS = "12345678";

	public List<rentareaEntity> findBuildingid(Long buildingid) {
		List<rentareaEntity>  results = new ArrayList<rentareaEntity>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// load driver Connection conn
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "select * from rentarea where buildingid = "+buildingid+" " ;
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // Display values
				rentareaEntity entity = new rentareaEntity();
				entity.setId(rs.getLong("id"));
				entity.setValue(rs.getInt("value"));
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
