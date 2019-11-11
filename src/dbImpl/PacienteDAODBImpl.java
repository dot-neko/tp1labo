package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.PacienteDAO;
import entidades.*;
import excepciones.BusinessException;

public class PacienteDAODBImpl implements PacienteDAO {

	public PacienteDAODBImpl() {
	}

	@Override
	public void deletePacienteByDocumento(String documento) throws BusinessException, SQLException {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			c.rollback();
			throw e;
		} finally {
			c.close();
		}
	}

	

	@Override
	public List<Paciente> getAllPacientes() throws SQLException {
		List<Paciente> respuesta = new ArrayList<Paciente>();
		String sql = "SELECT * FROM pacientes";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			c.commit();
			while (rs.next()) {
				int documento =  rs.getInt("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				respuesta.add(new Paciente(String.valueOf(documento),nombre,apellido,email));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			c.close();
		}
		return respuesta;

	}

	@Override
	public Paciente getPacienteByDocumento(String documento) throws BusinessException {
		Paciente retorna = null;
		String sql = "SELECT * FROM pacientes WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				retorna = new Paciente(String.valueOf(documento), nombre, apellido, email);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new BusinessException();
			} catch (SQLException e1) {
				throw new BusinessException();
			}
		} finally {
			try {
				c.commit();
				c.close();
			} catch (SQLException e1) {
				throw new BusinessException();
			}
		}
		return retorna;
	}




	@Override
	public void insertarPacientes(Paciente p) throws SQLException {
		String sql = "INSERT INTO pacientes (documento, nombre, apellido, email) VALUES ('" + p.getDocumento() + "', '" + p.getNombre()+ "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			c.rollback();
			throw new SQLException();
		} finally {
			c.close();
		}
		
	}

	@Override
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException , SQLException{
		String sql = "UPDATE pacientes set nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', email = '" + p.getEmail() + "' WHERE documento = '" + p.getDocumento() + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new BusinessException();
			} catch (SQLException e1) {
				throw new BusinessException();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BusinessException();
			}
		}
		
	}

	
	
}
