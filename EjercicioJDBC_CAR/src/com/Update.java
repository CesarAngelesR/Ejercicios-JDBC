package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	public static void main(String[] args) {
		Connection con = null;
		
		PreparedStatement ps = null;
		
		
		String update ="UPDATE CARRERAS SET NOMBRE=?, NUM_SEMESTRES=?, AREA=?, PRESUPUESTO_MENSUAL=? WHERE ID_CARRERA=?";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cangeles","admin");
			ps = con.prepareStatement(update);
			
			ps.setString(1, "ING. EN DESARROLLO DE SOFT");
			ps.setString(2, "8 SEMESTRES");
			ps.setString(3, "EXACTAS");
			ps.setDouble(4,44500.50);
			ps.setInt(5, 4);
			
			int bandera = ps.executeUpdate();

			if (bandera > 0) {
				System.out.println("Alumno actualizado correctamente");
			}

		} catch (Exception e) {
			System.out.println("El registro no pudo insertarse");
			e.printStackTrace();
		}

	}

}
