package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {

	public static void main(String[] args) {
			Connection con = null;
			
			PreparedStatement ps = null;
			
			
			String insert ="INSERT INTO CARRERAS VALUES(?,?,?,?,?)";
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cangeles","admin");
				ps = con.prepareStatement(insert);
				
				ps.setInt(1, 7);
				ps.setString(2, "LIC. EN CONTADURIA");
				ps.setString(3, "9 SEMESTRES");
				ps.setString(4, "CIENCIAS SOCIALES");
				ps.setDouble(5,78500.60);
				
				int bandera = ps.executeUpdate();

				if (bandera > 0) {
					System.out.println("Alumno registrado correctamente");
				}

			} catch (Exception e) {
				System.out.println("El registro no pudo realizarse correctamente");
				e.printStackTrace();
			}

	}

}
