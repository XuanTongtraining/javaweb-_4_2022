package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.iDistrictDao;
import com.laptrinhjavaweb.dao.entity.districtEntity;

@Repository
public class districtDaoImpl implements iDistrictDao {
	private final String DB_URL = "jdbc:mysql://localhost/databaseweb";
	private final String USER = "root";
	private final String PASS = "12345678";

	public districtEntity findDistrictId(Long id) {
		districtEntity results = new districtEntity();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// load driver Connection conn
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "select * from district where id = "+id+" " ;
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // Display values
				//districtEntity entity = new districtEntity();
				results.setId(rs.getLong("id"));
				results.setName(rs.getString("name"));
				results.setCode(rs.getString("code"));
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
