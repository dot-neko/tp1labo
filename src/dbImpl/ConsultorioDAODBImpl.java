package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.ConsultorioDAO;
import entidades.*;
import excepciones.BusinessException;

public class ConsultorioDAODBImpl implements ConsultorioDAO {

	public ConsultorioDAODBImpl() {
	}

	@Override
	public void deletePacienteByDocumento(String documento) throws SQLException {
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
	public Paciente getPacienteByDocumento(String documento) throws  SQLException {
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
			c.commit();
		} catch (SQLException e) {
			c.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			c.close();
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
			throw e;
		} finally {
			c.close();
		}
		
	}

	@Override
	public void updateUsuarioByDocumento(Paciente p) throws SQLException{
		String sql = "UPDATE pacientes set nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', email = '" + p.getEmail() + "' WHERE documento = '" + p.getDocumento() + "'";
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
	public void deletemedicoByDocumento(String documento) throws SQLException {
		String sql = "DELETE FROM medico WHERE documento = '" + documento + "'";
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
	public List<Medico> getAllMedicos() throws SQLException {
		List<Medico> respuesta = new ArrayList<Medico>();
		String sql = "SELECT * FROM medico";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			c.commit();
			while (rs.next()) {
				int documento =  rs.getInt("documento");
				int consultorio =rs.getInt("consultorio");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String especialidad = rs.getString("especialidad");
				respuesta.add(new Medico(String.valueOf(documento),String.valueOf(consultorio),nombre,apellido,especialidad));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			c.close();
		}
		return respuesta;

	}

	@Override
	public Medico getMedicoByDocumento(String documento) throws SQLException {
		Medico retorna = null;
		String sql = "SELECT * FROM medico WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				int consultorio = rs.getInt("consultorio");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String especialidad = rs.getString("especialidad");
				retorna = new Medico(String.valueOf(documento),String.valueOf(consultorio), nombre, apellido, especialidad);
			}
			c.commit();
		} catch (SQLException e) {
			c.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			c.close();
		}
		return retorna;
	}




	@Override
	public void insertarMedico(Medico m) throws SQLException {
		String sql = "INSERT INTO medico (documento, nombre, apellido, email) VALUES ('" + m.getDocumento() + "', '" + m.getConsultorio() + "', '" + m.getNombre()+ "', '" + m.getApellido() + "', '" + m.getEspecialidad()+ "')";
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
	public void updateMedicoByDocumento(Medico m) throws SQLException{
		String sql = "UPDATE medico set consultorio = '" + m.getConsultorio() + "', nombre = '" + m.getNombre() + "', apellido = '" + m.getApellido() + "', especialidad = '" +m.getEspecialidad() + "' WHERE documento = '" + m.getDocumento() + "'";
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

	
	
}
