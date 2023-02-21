package agencia_viajes;



import java.util.ArrayList;

import javax.swing.JOptionPane;

/**@DavidMangas **/

public class Menu {
	
	//Menu Principal
	public static void OpcionesMenuPrincipal(){
		
	
	final int OPCION_UNO = 1;
	final int OPCION_DOS = 2;
	final int OPCION_TRES = 3;
	final int OPCION_CUATRO = 4;
	final int SALIR = 0;
	int opcion_menu;
	do {
		opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
				"---------- Agencia David.SA ------------\n" + OPCION_UNO + ". Registra Clientes\n" + OPCION_DOS + ". Realizar Reservas\n"
						+ OPCION_TRES + ". Anula la reserva\n"+OPCION_CUATRO+ " Darse de altad en el hotel\n"+ SALIR + ". Cerrar el programa\n\n" + "¿Que desea Hacer?"));
		//fin menú
		switch (opcion_menu) {
		//Registra Clientes
		case OPCION_UNO:
			Menu.RegistrarClientes();
			
			break;
		//Realizar Reservas
		case OPCION_DOS:
			Menu.RealizarReservas();
			break;
		//Anula la reserva
		case OPCION_TRES:
			Menu.menuReservaEliminar();
			break;
		// Se da de alta en el hotel
		case OPCION_CUATRO: 
			Menu.RegistrarHoteles();
			//Funciona
			break;
			
		case SALIR:
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opcion incorrecta");
		}
	} while (opcion_menu != SALIR);
	}
	
	/**************************************************************************************************************************************************************************************/	
	
	//Menu de los clientes
	
	public static void RegistrarClientes() {
	
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int OPCION_TRES = 3;
		final int SALIR = 0;
		int opcion_menu;
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"-----------"
					+ "-MENU CLIENTES----------------\n" + OPCION_UNO + ". Darte de alta clientes\n"+OPCION_DOS+ ". Modificar clientes\n"+OPCION_TRES+ ". Eliminar Clientes \n"+ SALIR + ". Salir De Alta Clientes\n\n" + "¿Que desea Hacer?"));
			
			switch (opcion_menu) {
			// Registrar Clientes
			case OPCION_UNO:
				GestionDeClientes.InsertacionClientes();
				JOptionPane.showMessageDialog(null, "Cliente registrado");
				break;
			case OPCION_DOS:
				GestionDeClientes.ModificarClientes();
				JOptionPane.showMessageDialog(null, "Cliente Modificado");
				break;
			case OPCION_TRES:
				GestionDeClientes.EliminarClientes();
				JOptionPane.showMessageDialog(null, "Cliente eliminado");
				break;
			case SALIR:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (opcion_menu != SALIR);
		
	}
	
	/**************************************************************************************************************************************************************************************/	
	
	//Resgistro de hoteles
	public static void RegistrarHoteles() {
		
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int SALIR = 0;
		int opcion_menu;
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"-------------MENU HOTELES----------------\n" + OPCION_UNO + ". Darte de alta Hotel\n"+OPCION_DOS+". Habitaciones\n" + SALIR + ". Salir De Alta Clientes\n\n" + "¿Que desea Hacer?"));
			
			switch (opcion_menu) {
			// Registrar Clientes
			case OPCION_UNO:
				GestiondeHotel.Insertacionhoteles();
				JOptionPane.showMessageDialog(null, "Hotel registrado");
				final int AÑADIR = 1;
				final int SALIRR= 0;
				
				int opcion_menuu;
				do {
					opcion_menuu = Integer.parseInt(JOptionPane.showInputDialog(null,
							"------MENU AÑADIR HABITACIONES-------\n" + OPCION_UNO + ". Añadir Habitacion\n" + SALIRR + ". No añadir Habitacion\n"
									+ "Elije una de las opciones"));
					//fin menú
					switch (opcion_menuu) {
					case AÑADIR:
						GestiondeHotel.InsertacionHabiatcion();
						JOptionPane.showMessageDialog(null, "Habitacion Registrada");
						break;
					case SALIR:
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opcion incorrecta");
					}
				} while (opcion_menuu != SALIRR);
				
				
				break;
			case OPCION_DOS:
				GestiondeHotel.InsertacionHabiatcion();
				JOptionPane.showMessageDialog(null, "Habitacion Registrada");
				break;
			case SALIR:
				
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (opcion_menu != SALIR);
		
	}
	
	
/**************************************************************************************************************************************************************************************/
	
	public static void RealizarReservas() {
		final int OPCION_UNO = 1;
		final int OPCION_DOS = 2;
		final int SALIR = 0;
		int opcion_menu;
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"-------------MENU RESERVAS----------------\n" + OPCION_UNO + ". Introduce el DNI para hacer la reserva\n"+OPCION_DOS+". Ver hoteles\n"+ SALIR + ". Salir\n\n" + " ¿Que desea Hacer?"));
			//fin menú
			switch (opcion_menu) {
			//Comprueba el DNI 
			case OPCION_UNO:
				GestionDeReservas.ComprobadorDNI(null);
				
			case OPCION_DOS:
				
			 ArrayList<Hoteles> hoteles = new ArrayList<Hoteles>();
			 hoteles= GestionDeReservas.getHoteles();
			GestionDeReservas.mostrarHotel(hoteles);
				
				break;
			case SALIR:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (opcion_menu != SALIR);
		
			
		}
	public static void menuReservaEliminar(){
		final int OPCION_UNO = 1;
		
		final int SALIR = 0;
		int opcion_menu;
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"------Menu Eliminar Reserva-------\n" + OPCION_UNO + ". Eliminar reserva\n" + SALIR + ". Salir\n\n" + "¿Que desea Hacer?"));
			//fin menú
			switch (opcion_menu) {
			//Cancela reservas
			case OPCION_UNO:
				GestionDeReservas.eliminarReserva();
				JOptionPane.showInputDialog(null, "Reserva Cancelada");
				break;
				
			case SALIR:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		} while (opcion_menu != SALIR);
		
		
	}
	
	
		
	public void run() {
	OpcionesMenuPrincipal();
	}
}
