package agencia_viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class FormularioDeDatos {
// Aqui pongo toda la logica de la App (Insertar,Eliminar....)
	
	private static final String HOST = "localhost";
	private static final String BBDD = "agencia_viajes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public static void InsertarCliente(String Clientes){
		Clientes cliente=  new Clientes();
		cliente.setDni(JOptionPane.showInputDialog(null, "Introduce el DNI del Cliente"));
		cliente.setNombre(JOptionPane.showInputDialog(null, "Introduce el Nombre del Cliente"));
		cliente.setApellido(JOptionPane.showInputDialog(null, "Introduce el Apellido del Cliente"));
		cliente.setDireccion(JOptionPane.showInputDialog(null, "Introduce la direccion del Cliente"));
		cliente.setLocalidad(JOptionPane.showInputDialog(null, "Introduce la Localidad del Cliente"));
		
		
		try {
			if (insertarEnLaBBDD(cliente)) {
				System.out.println("Cliente insertado");
			} else {
				System.out.println("Error al insertar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	private static boolean insertarEnLaBBDD(Clientes cliente) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "INSERT INTO clientes(dni, nombre, apellidos, direccion, localidad) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getApellido());
			pst.setString(4, cliente.getDireccion());
			pst.setString(5, cliente.getLocalidad());
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
	
	private static void AnularReserva(){
		
	}

	
	
	
}
