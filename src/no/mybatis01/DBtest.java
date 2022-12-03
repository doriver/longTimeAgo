package no.mybatis01;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		String query = "INSERT INTO `real_estate`\r\n"
				+ "(`realtorId`, `address`, `area`, `type`, `price`, `rentPrice`, `createdAt`, `updatedAt`)\r\n"
				+ "VALUE (4, '헤라펠리스 444동 5305호', 350, '매매', 1500000, NULL, now(), now());";
		
		int count = 0;
		try {
			count = mysqlService.update(query);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		System.out.println(count + " 행 삽입!!");
		
		String selectQuery = "SELECT * FROM `real_estate` ORDER BY `id` DESC LIMIT 10;";
		
		try {
			ResultSet resultSet = mysqlService.select(selectQuery);
			
			while(resultSet.next()) {
				System.out.print("매물 주소 : " + resultSet.getString("address"));
				System.out.print(", 면적 : " + resultSet.getInt("area"));
				System.out.println(", 타입 : " + resultSet.getString("type"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		try {
			mysqlService.disconnect(); // DB 연결 해제
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
