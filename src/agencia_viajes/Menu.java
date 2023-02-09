package agencia_viajes;

import javax.swing.JOptionPane;

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
				"------MENU-------\n" + OPCION_UNO + ". Registra Clientes\n" + OPCION_DOS + ". Realizar Reservas\n"
						+ OPCION_TRES + ". Anula la reserva\n"+OPCION_CUATRO+ " Darse de altad en el hotel\n"+ SALIR + ". Cerrar el programa\n" + "Elije una de las opciones"));
		//fin menú
		switch (opcion_menu) {
		//Registra Clientes
		case OPCION_UNO:
			Menu.RegistrarClientes();
			
			break;
		//Realizar Reservas
		case OPCION_DOS:
		
			break;
		//Anula la reserva
		case OPCION_TRES:
			
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
					"------MENU-------\n" + OPCION_UNO + ". Darte de alta clientes\n"+OPCION_DOS+ ". Modificar clientes\n"+OPCION_TRES+ ". Eliminar Clientes \n"+ SALIR + ". Salir De Alta Clientes\n" + "Elije, la opcion a realizar"));
			
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
					"------MENU-------\n" + OPCION_UNO + ". Darte de alta Hotel\n"+OPCION_DOS+". Habitaciones\n" + SALIR + ". Salir De Alta Clientes\n" + "Elije, la opcion a realizar"));
			
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
	
	public void run() {
	OpcionesMenuPrincipal();
	}
}
