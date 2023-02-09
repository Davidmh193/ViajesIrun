package agencia_viajes;

public class GestionDeClientes {
//Llega la informacion de Formulario de datos.
	
	
	public static void InsertacionClientes(){
		FormularioDeDatos.InsertarCliente(null);
	}
	public static void EliminarClientes(){
		FormularioDeDatos.eliminarCliente();
	}
	public static void ModificarClientes(){
		FormularioDeDatos.modificarDatosClientes();
	}
	
}
