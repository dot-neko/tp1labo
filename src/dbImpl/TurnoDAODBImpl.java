package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.*;

import dao.TurnoDAO;
import entidades.*;
import excepciones.BusinessException;

public class TurnoDAODBImpl implements TurnoDAO {

	public TurnoDAODBImpl() {
		TableManager.createPacTable();
		TableManager.createMedicoTable();
		TableManager.createTurnosTable();
	}

	@Override
	public void CrearTurnosMedicos(Turno turno) throws BusinessException {
		String sql = "INSERT INTO turno (documento_medico, fecha_hora, consultorio, reservado) "
				+ "VALUES ('" + turno.getdocumentoMedico() + "', '" + turno.getFecha_hora() + "', '" + turno.getConsultorio()+ "', '" + turno.getReservado() + "')";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
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

	public List<String> BuscarTurnos(Turno b) throws BusinessException {
		List<String> respuesta = new ArrayList<String>();
		int documentomedico = Integer.valueOf(b.getdocumentoMedico());
		String sql = "SELECT * FROM turno WHERE documento_medico = '" + documentomedico + "'"
				+ "AND reservado = '0'";//TODO Incorporar fecha superior a hoy
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
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
	public void ReservaTurno(Turno t) throws BusinessException{
		String sql = "UPDATE turno "
				+ "set documento_paciente = '" + t.getdocumentoPaciente() + "', "
						+ "reservado = '" + t.getReservado() + "' "
				+ "WHERE fecha_hora = '" + t.getFecha_hora() + "'"
						+ "AND documento_medico = '" + t.getdocumentoMedico() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
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
