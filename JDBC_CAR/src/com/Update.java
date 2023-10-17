package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	public static void main(String[] args) {
		// UPDATE -actualizacion de un registro

		Connection con = null;

		PreparedStatement ps = null;

		String update = "UPDATE ALUMNO SET NOMBRE=?, FECHA_NAC=?, GENERO=?, GRADO=? WHERE ID_ALUMNO=?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cangeles", "admin");
			ps = con.prepareStatement(update);

			//Asignamos valores a actualizar de un registro en la base de datos
			//y respetamos el orden en que aparecen las columnas en la sentencia SQL, es decir, el nombre
			//de la primer columna
			
			ps.setString(1, "ANDRES");
			ps.setString(2, "20/04/1990");
			ps.setString(3, "MASCULINO");
			ps.setString(4, "3er semestre");
			ps.setInt(5, 27);
			
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
