package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import basics.*;

import dao.UsuarioDAO;
import entidades.*;

public class UsuarioDAODBImpl implements UsuarioDAO {

	@Override
	public void deletePacienteByDocumento(int documento) {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
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

	@Override
	public Collection<?> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pacientes getPacienteByDocumento(int documento) {
		Pacientes retorna = null;
		String sql = "SELECT * FROM pacientes WHERE documento = '" + documento + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String n = rs.getString("nombre");
				String a = rs.getString("apellido");
				String e = rs.getString("email");
				retorna = new Pacientes(documento, n, a, e);
				retorna.setDocumento(documento);
				retorna.setNombre(n);
				retorna.setApellido(a);
				retorna.setEmail(e);
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
				c.commit();
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return retorna;
	}




	@Override
	public void insertarPacientes(Pacientes p) {
		String sql = "INSERT INTO pacientes (documento, nombre, apellido, email) VALUES ('" + p.getDocumento() + "', '" + p.getNombre()+ "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
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

	@Override
	public void updateUsuarioByDocumento(int documento, Pacientes p)  {
		String sql = "UPDATE pacientes set email = '" + p.getNombre() + "', pass = '" + p.getApellido() + "' WHERE user = '" + documento + "'";
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

	
	
}
