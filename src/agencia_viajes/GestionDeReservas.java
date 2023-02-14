package agencia_viajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestionDeReservas extends Conector{

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
				GestionDeReservas.ComprobadorHotel(Clientes);
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
			for (Hoteles hotel : hoteles) {
				System.out.println("Nombre del hotel "+hotel);
			}
		}

		/*public static void mostrarLibro(Hoteles hotel) {
			System.out.println(hotel);
		}

		public static void mostrar(String mensaje) {
			System.out.println(mensaje);
		}*/
		
		
		public ArrayList<Hoteles> getHoteles() {

			
			ArrayList<Hoteles> hoteles = new ArrayList<Hoteles>();
			Statement st;
			try {
				
				st = this.con.prepareStatement(null);
				ResultSet rs = st.executeQuery("select * from hoteles");

				Hoteles hotel;
				while (rs.next()) {
					hotel = new Hoteles();
					hotel.setId(rs.getInt("id"));
					hotel.setCif(rs.getString("cif"));
					hotel.setNombre(rs.getString("nombre"));
					hotel.setGerente(rs.getString("gerente"));
					hotel.setEstrella(rs.getInt("estrellas"));
					hotel.setCompania(rs.getString("compania"));
					
					
					hoteles.add(hotel);
				}
				return hoteles;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
}
	
