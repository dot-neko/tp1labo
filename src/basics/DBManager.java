package basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	// Par�metros de DB
	private static final String url = "jdbc:sqlite:consultorio.db";
	private static final String db_driver = "org.sqlite.JDBC";
	
	//Singleton
	private static DBManager instance = new DBManager();

	private DBManager() {
	}
	
	public static DBManager getInstance() {
		return instance;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(db_driver); // Intenta verificar driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // println de stack
			System.exit(0); // sale de sistema
		}
		try {
			conn = DriverManager.getConnection(url); // intenta conectar
			conn.setAutoCommit(false); // Desactiva Autocommit
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			
		}

		return conn;
	}

	
	

}
