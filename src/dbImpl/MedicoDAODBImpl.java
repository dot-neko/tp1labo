package dbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.MedicoDAO;
import entidades.*;
import excepciones.BusinessException;

public class MedicoDAODBImpl implements MedicoDAO {

	public MedicoDAODBImpl() {
		TableManager.createPacTable();
		TableManager.createMedicoTable();
		TableManager.createTurnosTable();
	}

	@Override
	public void deletemedicoByDocumento(int documento) throws BusinessException {
		String sql = "DELETE FROM medico WHERE medico_id = ?";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			pstmt.setInt(1,documento);
			pstmt.executeUpdate();
			c.commit();
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
	public List<Medico> getAllMedicos() throws BusinessException {
		List<Medico> respuesta = new ArrayList<Medico>();
		String sql = "SELECT * FROM medico";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int documento =  rs.getInt("medico_id");
				int consultorio =rs.getInt("consultorio");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String especialidad = rs.getString("especialidad");
				respuesta.add(new Medico(String.valueOf(documento),String.valueOf(consultorio),nombre,apellido,especialidad));
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
	public Medico getMedicoByDocumento(int documento) throws BusinessException {
		Medico retorna = null;
		String sql = "SELECT * FROM medico WHERE medico_id = ?";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			pstmt.setInt(1,documento);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int consultorio = rs.getInt("consultorio");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String especialidad = rs.getString("especialidad");
				retorna = new Medico(String.valueOf(documento),String.valueOf(consultorio), nombre, apellido, especialidad);
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
	public void insertarMedico(int documento, int consultorio, String nombre, String apellido, String especialidad) throws BusinessException {
		String sql = "INSERT INTO medico (medico_id, consultorio, nombre, apellido, especialidad) VALUES (?,?,?,?,?)";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setInt(1,documento);
			pstmt.setInt(2, consultorio);
			pstmt.setString(3, nombre);
			pstmt.setString(4, apellido);
			pstmt.setString(5, especialidad);
			pstmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
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
	public void updateMedicoByDocumento(int documento, int consultorio, String nombre, String apellido, String especialidad) throws BusinessException{
		String sql = "UPDATE medico set medico_id= ?, consultorio = ?, nombre = ?, apellido = ?, especialidad = ? WHERE medico_id = ? ";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setInt(1,documento);
			pstmt.setInt(2, consultorio);
			pstmt.setString(3, nombre);
			pstmt.setString(4, apellido);
			pstmt.setString(5, especialidad);
			pstmt.setInt(6,documento);
			pstmt.executeUpdate();
			c.commit();
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
