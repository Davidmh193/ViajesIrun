package agencia_viajes;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GestorAgenciaRun {
// Va a ser el run
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
		Menu gh = new Menu();
		gh.run();
		
	}
}
