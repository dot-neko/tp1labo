package dbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.PacienteDAO;
import entidades.Paciente;
import excepciones.BusinessException;

public class PacienteDAODBImpl implements PacienteDAO {

	public PacienteDAODBImpl() {
		TableManager.createPacTable();
		TableManager.createMedicoTable();
		TableManager.createTurnosTable();
	}

	@Override
	public void deletePacienteByDocumento(int documento) throws BusinessException {
		String sql = "DELETE FROM pacientes WHERE paciente_id = ? ";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			pstmt.setInt(1,documento);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO, e1.getMessage(), BusinessException.TYPE_SQL);
			}
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			}
		}
	}

	

	@Override
	public List<Paciente> getAllPacientes() throws BusinessException {
		List<Paciente> respuesta = new ArrayList<Paciente>();
		String sql = "SELECT * FROM pacientes";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int documento =  rs.getInt("paciente_id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				respuesta.add(new Paciente(String.valueOf(documento),nombre,apellido,email));
			}
		} catch (SQLException e) {
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			}
		}
		return respuesta;

	}

	@Override
	public Paciente getPacienteByDocumento(int documento) throws BusinessException {//TODO
		Paciente retorna = null;
		String sql = "SELECT * FROM pacientes WHERE paciente_id = ?";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			pstmt.setInt(1,documento);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				retorna = new Paciente(String.valueOf(documento), nombre, apellido, email);
			}
			c.commit();
		} catch (SQLException e) {
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			}
		}
		return retorna;
	}




	@Override
	public void insertarPacientes(int paciente_id, String nombre,String apellido,String email) throws BusinessException {
		String sql = "INSERT INTO pacientes (paciente_id, nombre, apellido, email) VALUES (?,?,?,?)";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setInt(1,paciente_id);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO, e1.getMessage(), BusinessException.TYPE_SQL);
			}
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			}
		}
		
	}

	@Override
	public void updateUsuarioByDocumento(int documento, String nombre, String apellido, String email) throws BusinessException{
		String sql = "UPDATE pacientes set nombre = ?, apellido = ?, email = ? WHERE paciente_id = ?";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setString(3, email);
			pstmt.setInt(4,documento);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO, e1.getMessage(), BusinessException.TYPE_SQL);
			}
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
			}
		}
		
	}

}
