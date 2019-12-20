package dbImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.TurnoDAO;
import excepciones.BusinessException;

public class TurnoDAODBImpl implements TurnoDAO {

	public TurnoDAODBImpl() {
		TableManager.createPacTable();
		TableManager.createMedicoTable();
		TableManager.createTurnosTable();
	}

	@Override
	public void CrearTurnosMedicos(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException {
		String sql = "INSERT INTO turno (documento_medico, fecha_hora, consultorio, reservado) "
				+ "VALUES (?,?,?,?)";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setInt(1,docmed);
			pstmt.setString(2, turno);
			pstmt.setInt(3, docpac);
			pstmt.setInt(4, consultorio);
			pstmt.setInt(5, reservado);
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

	public List<String> BuscarTurnos(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException {
		List<String> respuesta = new ArrayList<String>();
		String sql = "SELECT * FROM turno WHERE documento_medico = ? AND reservado = ?";
		Connection c = DBManager.getInstance().connect();
		try (PreparedStatement pstmt= c.prepareStatement(sql)){
			pstmt.setInt(1,docmed);
			pstmt.setInt(2, 0);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String fecha_hora = rs.getString("fecha_hora");
				respuesta.add(fecha_hora);
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
		return respuesta;
		
	}

	@Override
	public void ReservaTurno(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException{
		String sql = "UPDATE turno set documento_paciente = ?, reservado = ? WHERE fecha_hora = ? AND documento_medico = ?";
		Connection c = DBManager.getInstance().connect();
		try(PreparedStatement pstmt= c.prepareStatement(sql)) {
			pstmt.setInt(1,docpac);
			pstmt.setInt(2, reservado);
			pstmt.setString(3, turno);
			pstmt.setInt(4, docmed);
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
