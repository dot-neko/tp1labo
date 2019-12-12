package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



//Encargado de generar las tablas
public class TableManager {

	public static void createPacTable() {

		Connection conn = DBManager.getInstance().connect(); 		//Declaro conexion
		
		//String a ejecutar
		String sql = "CREATE TABLE IF NOT EXISTS pacientes (paciente_id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "	email text NOT NULL);";
		
		try {
			Statement s = conn.createStatement();		//Intenta ejecutar un statement
			s.execute(sql);		
			conn.commit();								//envia el codigo
		} catch (SQLException e) {						//sqlexception ataja muchos de los errores de integridad
			try {
				conn.rollback();						//Intenta rollback
				e.printStackTrace();					//Imprime stack
			} catch (SQLException e1) {					//Si falla el rollback
				e1.printStackTrace();
			}
		} finally {										//Tanto por el try o por los catch, se ejecute el finally antes de salir del metodo, ya que tiene un throws
			try {
				conn.close();							//Cerrar la conexion
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

	}
	
	public static void dropPacTable() {

		Connection c = DBManager.getInstance().connect();
		
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
	
	public static void createMedicoTable() {

		Connection conn = DBManager.getInstance().connect(); 		//Declaro conexion
		
		//String a ejecutar
		String sql = "CREATE TABLE IF NOT EXISTS medico (medico_id integer PRIMARY KEY ,\n"
                + "	consultorio integer NOT NULL,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "	especialidad text NOT NULL);";
		
		try {
			Statement s = conn.createStatement();		//Intenta ejecutar un statement
			s.execute(sql);		
			conn.commit();								//envia el codigo
		} catch (SQLException e) {						//sqlexception ataja muchos de los errores de integridad
			try {
				conn.rollback();						//Intenta rollback
				e.printStackTrace();					//Imprime stack
			} catch (SQLException e1) {					//Si falla el rollback
				e1.printStackTrace();
			}
		} finally {										//Tanto por el try o por los catch, se ejecute el finally antes de salir del metodo, ya que tiene un throws
			try {
				conn.close();							//Cerrar la conexion
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
		
	public static void dropMedTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE medico";
		
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
	
	public static void createTurnosTable() {

		Connection conn = DBManager.getInstance().connect(); 		//Declaro conexion
		
		//String a ejecutar
		String sql = "CREATE TABLE IF NOT EXISTS turno (turno_id integer PRIMARY KEY AUTOINCREMENT,\n"
				+ "	documento_medico integer NOT NULL,\n"
                + "	fecha_hora text NOT NULL,\n"
                + "	documento_paciente integer,\n"
                + "	consultorio integer,"
                + " reservado integer DEFAULT 0,"
                + " UNIQUE(documento_medico,fecha_hora)"
                
                + " FOREIGN KEY (documento_medico)\n" + 
                "       REFERENCES medico (medico_id)"
                + " FOREIGN KEY (documento_paciente)\n" + 
                "       REFERENCES pacientes (paciente_id)"
                + " );";
		
		try {
			Statement s = conn.createStatement();		//Intenta ejecutar un statement
			s.execute(sql);		
			conn.commit();								//envia el codigo
		} catch (SQLException e) {						//sqlexception ataja muchos de los errores de integridad
			try {
				conn.rollback();						//Intenta rollback
				e.printStackTrace();					//Imprime stack
			} catch (SQLException e1) {					//Si falla el rollback
				e1.printStackTrace();
			}
		} finally {										//Tanto por el try o por los catch, se ejecute el finally antes de salir del metodo, ya que tiene un throws
			try {
				conn.close();							//Cerrar la conexion
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
		
	public static void dropTurnosTable() {

		Connection c = DBManager.getInstance().connect();
		
		String sql = "DROP TABLE turno";
		
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
