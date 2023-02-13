package agencia_viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GestionDeReservas {

	private static final String HOST = "localhost";
	private static final String BBDD = "agencia_viajes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	
	/**************************************************************************************************************************************************************************************/

	//Comprueba si esta el DNI
	public static void ComprobadorDNI(String Clientes) {
		 Clientes dni=  new Clientes();
		 dni.setDni(JOptionPane.showInputDialog(null, "Introduce la id del Cliente"));
		 
					
			if (buscadorEnLaBBDDD(dni)) {
				JOptionPane.showMessageDialog(null, "Cliente encontrado");
				Menu.RegistrarHoteles();
			} else {
				System.out.println("Error en la eliminacion");
			}
		}
	private static boolean buscadorEnLaBBDDD(Clientes dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "SELECT * FROM clientes WHERE dni = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, dni.getDni());
			pst.execute();
			return true;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado, falta el jar");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Fallo en la conexion");
			e.printStackTrace();
			return false;
		}

	}
	/**************************************************************************************************************************************************************************************/
		
	
}
	
