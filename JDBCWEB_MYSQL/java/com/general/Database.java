package com.general;

import java.sql.*;

public class Database {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER= "root";
	private static final String JDBC_PASSWORD= "NCae7884";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);	
	}
	public static void close(ResultSet rs) throws SQLException {
		rs.close();	
	}
	public static void close(Statement smtm) throws SQLException {
		smtm.close();	
	}
	public static void close(PreparedStatement smtm) throws SQLException {
		smtm.close();	
	}
	public static void close(Connection con) throws SQLException {
		con.close();	
	}

}
