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
	/**************************************************************************************************************************************************************************************/
	
	//Modifica el cliente 
	public static void modificarDatosClientes() {
		Clientes cliente=  new Clientes();
		cliente.setDni(JOptionPane.showInputDialog(null, "Introduce el DNI del Cliente"));
		cliente.setNombre(JOptionPane.showInputDialog(null, "Introduce el Nombre del Cliente"));
		cliente.setApellido(JOptionPane.showInputDialog(null, "Introduce el Apellido del Cliente"));
		cliente.setDireccion(JOptionPane.showInputDialog(null, "Introduce la direccion del Cliente"));
		cliente.setLocalidad(JOptionPane.showInputDialog(null, "Introduce la Localidad del Cliente"));
		
		if (modificarEnLaBBDDClientes(cliente)) {
			System.out.println("Cliente modificado");
		}else {
			System.out.println("Error al modificar");
		}

	}	
	private static boolean modificarEnLaBBDDClientes(Clientes cliente) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "UPDATE clientes SET nombre=?, apellidos=?, direccion=?, localidad=? WHERE dni=?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getApellido());
			pst.setString(3, cliente.getDireccion());
			pst.setString(4, cliente.getLocalidad());
			pst.setString(5, cliente.getDni());
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
	//Eliminar clientes
	
	
	public static void eliminarCliente(){
		String dni=JOptionPane.showInputDialog(null, "Inserte la id del Cliente a eliminar");

		Clientes eliminar = new Clientes();
		eliminar.setDni(dni);			
		if (eliminarClienteDelaBBDD(dni)) {
			System.out.println("Cliente Eliminado correctamente");
		} else {
			System.out.println("Error en la eliminacion");
		}
	}

	private static boolean eliminarClienteDelaBBDD(String dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "DELETE FROM clientes WHERE dni = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, dni);
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
	
	//Inserta Datos del Hotel
	
	public static void InsertarDatosHotel(String Hoteles) {
		Hoteles hoteles=  new Hoteles();
		hoteles.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id del Hotel")));
		hoteles.setCif(JOptionPane.showInputDialog(null, "Introduce el Cif del Hotel"));
		hoteles.setNombre(JOptionPane.showInputDialog(null, "Introduce el Nombre del Cliente"));
		hoteles.setGerente(JOptionPane.showInputDialog(null, "Introduce la Nombre del Gerente"));
		hoteles.setEstrella(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el NUMERO de ESTRELLAS del HOTEL")));
		hoteles.setCompania(JOptionPane.showInputDialog(null, "Introduce el Cif del Hotel"));

		try {
			if (insertarEnLaBBDDD(hoteles)) {
				System.out.println("Hotel insertado");
			} else {
				System.out.println("Error al insertar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static boolean insertarEnLaBBDDD(Hoteles hoteles) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "INSERT INTO hoteles(id, cif, nombre, gerente, estrellas, compania) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, hoteles.getId());
			pst.setString(2, hoteles.getCif());
			pst.setString(3, hoteles.getNombre());
			pst.setString(4, hoteles.getGerente());
			pst.setInt(5, hoteles.getEstrella());
			pst.setString(6, hoteles.getCompania());
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

	// Habitaciones.
	
	public static void InsertarDatosHabitaciones(String Habitaciones) {
		Habitaciones habitaciones=  new Habitaciones();
		habitaciones.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id de la habitacion")));
		habitaciones.setId_hotel(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id el hotel")));
		habitaciones.setNumero(JOptionPane.showInputDialog(null, "Introduce el numero de habitacion"));
		habitaciones.setDescripcion(JOptionPane.showInputDialog(null, "Introduce la descripcion del hotel"));
		habitaciones.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el precio por noche de la habitacion")));
		

		try {
			if (insertarHabitacionEnLaBBDDD(habitaciones)) {
				System.out.println("Habitacion insertado");
			} else {
				System.out.println("Error al insertar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static boolean insertarHabitacionEnLaBBDDD(Habitaciones habitaciones) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "INSERT INTO habitaciones(id, id_hotel, numero, descripcion, precio) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, habitaciones.getId());
			pst.setInt(2, habitaciones.getId_hotel());
			pst.setString(3, habitaciones.getNumero());
			pst.setString(4, habitaciones.getDescripcion());
			pst.setDouble(5, habitaciones.getPrecio());
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
	
	//Realizar Reservas
	
	
	
	
}
