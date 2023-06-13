package com.dataccess.dataccessdemo;
import java.sql.*;
public class MavenJdbcDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		Statement stat=null;
		//driver class name
		final String DRIVER="oracle.jdbc.driver.OracleDriver";
		//url,username,password details
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String username="system";
		String password="Phani@1436";
		
		//driver registered
		Class.forName(DRIVER);
		System.out.println(DRIVER);
		try {
			//create the connection
			conn=DriverManager.getConnection(url, username, password);
			if(conn!=null) {
				System.out.println("Connected to database! "+conn);
			}else {
				System.out.println("Not connected to database!");
			}
			
			//creation of statement
			
			stat=conn.createStatement();
			
			String sql="select * from TRAINEE.PRODUCT";
			//execution of statement
			ResultSet rs=stat.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("pid: "+rs.getInt(1)+"pname: "+rs.getString(2)+"pprice: "+rs.getInt(3));
			}
				
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally {
			stat.close();
			conn.close();
		}
	}

}
