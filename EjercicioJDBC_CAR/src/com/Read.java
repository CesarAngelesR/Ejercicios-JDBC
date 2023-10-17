package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {

	public static void main(String[] args) {
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs= null;
		
		String select ="SELECT * FROM CARRERAS";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cangeles","admin");
			ps = con.prepareStatement(select);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("ID_CARRERA")
						+ " : " + rs.getString("NOMBRE") 
						+ " : " + rs.getString("NUM_SEMESTRES")
						+ " : " + rs.getString("AREA") 
						+ " : " + rs.getDouble("PRESUPUESTO_MENSUAL"));
			}
						
		} catch (Exception e) {
			System.out.println("No se pudo realizar la consulta");
			e.printStackTrace();
		}
	}

}
