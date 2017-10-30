package basics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManager {

	public static void crearUsuario(int documento, String nombre, String apellido, String email) {
		String sql = "INSERT INTO pacientes (documento, nombre, apellido, email) VALUES ('" + documento + "'"
																						+ ",'" + nombre + "'"
																						+ ", '" + apellido + "'"
																						+ ", '" + email + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();							//Hace el cambio en la base
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void borraUsuario(String username) {
		String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void actualizaUsuario(String user, String email, String pass) {
		String sql = "UPDATE usuarios set email = '" + email + "', pass = '" + user + "' WHERE user = '" + user + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}

	}
	//Los select son diferentes a los otros statements
	public void muestraUsuario(String username) {
		String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();		
			ResultSet rs = s.executeQuery(sql);			//Me devuelve resultados unicos ResultSet(hay que preguntarle si tiene siguiente)
			
			if(rs.next()) {								//el next salta a la siguiente linea si existe.
				System.out.println("Usuario:");			//Cambiar a lista, dentro un arraylist
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
				//NO es buena practica poner return en los try
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	public void muestraTodosLosusuarios() {
		String sql = "SELECT * FROM usuarios";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Usuario:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("email"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
}
