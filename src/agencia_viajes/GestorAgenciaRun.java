package agencia_viajes;

import java.io.FileNotFoundException;
import java.sql.SQLException;
/**@DavidMangas **/
public class GestorAgenciaRun {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
		Menu gh = new Menu();
		gh.run();
		
		
	}
}
