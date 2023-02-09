package agencia_viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GestionDeReservas {

	private static final String HOST = "localhost";
	private static final String BBDD = "agencia_viajes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	

	
	public static void ArrayReservas() {
		
	
	String dni[] = new String[5];
	String[] lineas = new String[5];
	String DNIVerificacion;
	int f = 0;
	int menu = 0;
	boolean Dnilogin = false;
	int retirado;
	boolean guardado = true;
	int introducir;
	String datos;
	String sino;
	
	// Pide el DNI Y confirma si esta.
	
	
	f = 0;
	DNIVerificacion = JOptionPane.showInputDialog(null, "Introduce DNI");
	for (int contador = 0; contador < dni.length; contador++) {
		
		if (dni[contador].equals(DNIVerificacion)) {
			f = contador;
			menu = contador;
			Dnilogin = true;
		}
	}
	if (Dnilogin == false) {
		JOptionPane.showMessageDialog(null, "Vuleve a iniciar el programa esta mal metido");
		System.exit(0);
	}
	
	
	private static boolean eliminarClienteDelaBBDD(String dni) {
		
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);
	
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
		
			
	
}
}	
