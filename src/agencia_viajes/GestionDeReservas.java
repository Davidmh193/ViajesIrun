package agencia_viajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestionDeReservas extends Conector{

	private static final String HOST = "localhost";
	private static final String BBDD = "agencia_viajes";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	static Conector con = new Conector();
	PreparedStatement ps;
	
	/**************************************************************************************************************************************************************************************/

	//Comprueba si esta el DNI
	public static void ComprobadorDNI(String Clientes) {
		 Clientes dni=  new Clientes();
		 dni.setDni(JOptionPane.showInputDialog(null, "Introduce la id del Cliente"));
		 
					
			if (buscadorEnLaBBDDD(dni)) {
				JOptionPane.showMessageDialog(null, "Cliente encontrado");
				GestionDeReservas.ComprobadorHotel(Clientes);
				GestionDeReservas.HacerReserva(Clientes);
			
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
	public static void ComprobadorHotel(String Hoteles) {
		Hoteles hoteles=  new Hoteles();
		 hoteles.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el hotel a reservar")));
		 
					
			if (buscadorEnLaBBDDD(hoteles)) {
				JOptionPane.showMessageDialog(null, "Hotel encontrado");
				
			} else {
				System.out.println("Error en la eliminacion");
			}
		}
	private static boolean buscadorEnLaBBDDD(Hoteles hoteles) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "SELECT * FROM hoteles WHERE id = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, hoteles.getId());
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
	
	//Array List de Ver Las habitaciones 
	
	public static void mostrarHotel(ArrayList<Hoteles> hoteles) {
	    for (Hoteles hotel: hoteles) {
	        System.out.println("Nombre del hotel: " + hotel);
	    }
	}

	public static ArrayList<Hoteles> getHoteles() {
	    ArrayList<Hoteles> hoteles = new ArrayList<Hoteles>();
   
	    
	    try {
	        con.conectar();
	        PreparedStatement ps = con.getCon().prepareStatement("SELECT * from hoteles");
	        ResultSet res = ps.executeQuery();
	        while (res.next()) {
	            Hoteles hotel = new Hoteles();
	            hotel.setId(res.getInt("id"));
	            hotel.setCif(res.getString("cif"));
	            hotel.setNombre(res.getString("nombre"));
	            hotel.setGerente(res.getString("gerente"));
	            hotel.setEstrella(res.getInt("estrellas"));
	            hotel.setCompania(res.getString("compania"));
	            hoteles.add(hotel);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        con.cerrar();
	    }
	    return hoteles;
	}
	
	/**************************************************************************************************************************************************************************************/
	
	// Insertar reservas
	public static void HacerReserva(String Reserva) {
		Reservas reserva=  new Reservas();
		
		reserva.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id de la reserva")));
		reserva.setId_habitacion(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la id de la habitacion")));
		reserva.setDni(JOptionPane.showInputDialog(null, "Introduce el DNI"));
		reserva.setDesde(java.sql.Date.valueOf(JOptionPane.showInputDialog(null, "Introduce la fecha de inicio de reserva")));
		reserva.setHasta(java.sql.Date.valueOf(JOptionPane.showInputDialog(null, "Introduce la fecha de final de reseva")));
		
		

		try {
			if (insertarReservaEnLaBBDDD(reserva)) {
				System.out.println("Reserva completada");
			} else {
				System.out.println("Error al insertar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static boolean insertarReservaEnLaBBDDD(Reservas reserva) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "INSERT INTO reservas(id, id_habitacion, dni, desde, hasta) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, reserva.getId());
			pst.setInt(2, reserva.getId_habitacion());
			pst.setString(3, reserva.getDni());
			pst.setDate(4, (Date) reserva.getDesde());
			pst.setDate(5, (Date) reserva.getHasta());
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
		
	/**********************************************************************************************************************************************************************/	
		
	
	//eliminar reserva
	
	public static void eliminarReserva(){
		String id=JOptionPane.showInputDialog(null, "Inserte la id del id de la reserva a eliminar");
		
		Clientes eliminar = new Clientes();
		eliminar.setDni(id);			
		if (eliminarReservaDelaBBDD(id)) {
			System.out.println("Reserva Eliminada correctamente");
		} else {
			System.out.println("Error en la eliminacion");
		}
	}

	private static boolean eliminarReservaDelaBBDD(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BBDD, USERNAME, PASSWORD);

			String sql = "DELETE FROM reservas WHERE id = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, id);
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
	
	}
	
	

	