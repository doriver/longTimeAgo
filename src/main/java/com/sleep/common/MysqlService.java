package com.sleep.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlService {
	private String url;
	private String id;
	private String password;
	
	private Connection conn;
	private Statement statement;

	public MysqlService() {
		this.url = "jdbc:mysql://localhost:3306/leesang";
		this.id = "root";
		this.password = "root";
	}
	
	public void connection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			this.conn = DriverManager.getConnection(
					this.url,
					this.id,
					this.password);
			
			this.statement = conn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int uqdate(String query) throws SQLException {
		return this.statement.executeUpdate(query);
	}
	
	public void disconnect() {
		this
	}
}
