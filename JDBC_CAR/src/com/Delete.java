package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

	public static void main(String[] args) {
		// DELETE- Borrar un registro
		
		Connection con = null;

		PreparedStatement ps = null;

		String delete = "DELETE FROM ALUMNO WHERE ID_ALUMNO=?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cangeles", "admin");
			ps = con.prepareStatement(delete);

			//Asignamos valores del ID del registro a eliminar
			ps.setInt(1,1);

			
			int bandera = ps.executeUpdate();

			if (bandera > 0) {
				System.out.println("Alumno borrado correctamente");
			}

		} catch (Exception e) {
			System.out.println("El borrado no se realizo");
			e.printStackTrace();
		}

	}

}
