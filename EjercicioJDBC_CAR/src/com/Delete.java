package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

	public static void main(String[] args) {
		Connection con = null;

		PreparedStatement ps = null;

		String delete = "DELETE FROM CARRERAS WHERE ID_CARRERA=?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cangeles", "admin");
			ps = con.prepareStatement(delete);


			ps.setInt(1,7);

			
			int bandera = ps.executeUpdate();

			if (bandera > 0) {
				System.out.println("Carrera borrada correctamente");
			}

		} catch (Exception e) {
			System.out.println("El borrado no se realizó");
			e.printStackTrace();
		}


	}

}
