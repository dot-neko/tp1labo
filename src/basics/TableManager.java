package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


//Encargado de generar las tablas
public class TableManager {

	public static void createPacTable() {

		Connection conn = DBManager.getDBManager().connect(); 		//Declaro conexion
		
		//String a ejecutar
		String sql = "CREATE TABLE IF NOT EXISTS pacientes (paciente_id integer PRIMARY KEY,\n"
                + "	documento integer NOT NULL,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "	email text NOT NULL);";
		
		try {
			Statement s = conn.createStatement();		//Intenta ejecutar un statement
			s.execute(sql);								//envia el codigo
		} catch (SQLException e) {						//sqlexception ataja muchos de los errores de integridad
			try {
				conn.rollback();						//Intenta rollback
				e.printStackTrace();					//Imprime stack
			} catch (SQLException e1) {					//Si falla el rollback
				e1.printStackTrace();
			}
		} finally {										//Tanto por el try o por los catch, se ejecute el finally antes de salir del metodo, ya que tiene un throws
			try {
				conn.commit();
				conn.close();							//Cerrar la conexión
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public static void dropPacTable() {

		Connection c = DBManager.getDBManager().connect();
		
		String sql = "DROP TABLE pacientes";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
