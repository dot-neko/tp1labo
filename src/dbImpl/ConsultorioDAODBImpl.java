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
		/*TableManager.dropMedTable();
		TableManager.dropPacTable();
		TableManager.dropTurnosTable();*/
		TableManager.createPacTable();
		TableManager.createMedicoTable();
		TableManager.createTurnosTable();
	}

	@Override
	public void deletePacienteByDocumento(String documento) throws BusinessException {
		String sql = "DELETE FROM pacientes WHERE paciente_id = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
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

	

	@Override
	public List<Paciente> getAllPacientes() throws BusinessException {
		List<Paciente> respuesta = new ArrayList<Paciente>();
		String sql = "SELECT * FROM pacientes";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			c.commit();
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
	public Paciente getPacienteByDocumento(String documento) throws BusinessException {
		Paciente retorna = null;
		String sql = "SELECT * FROM pacientes WHERE paciente_id = '" + documento + "'";
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
	public void insertarPacientes(Paciente p) throws BusinessException {
		String sql = "INSERT INTO pacientes (paciente_id, nombre, apellido, email) VALUES ('" + p.getDocumento() + "', '" + p.getNombre()+ "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
		Connection c = DBManager.getDBManager().connect();
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

	@Override
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException{
		String sql = "UPDATE pacientes set nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', email = '" + p.getEmail() + "' WHERE paciente_id = '" + p.getDocumento() + "'";
		Connection c = DBManager.getDBManager().connect();
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

	@Override
	public void deletemedicoByDocumento(String documento) throws BusinessException {
		String sql = "DELETE FROM medico WHERE medico_id = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
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

	

	@Override
	public List<Medico> getAllMedicos() throws BusinessException {
		List<Medico> respuesta = new ArrayList<Medico>();
		String sql = "SELECT * FROM medico";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			c.commit();
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
	public Medico getMedicoByDocumento(String documento) throws BusinessException {
		Medico retorna = null;
		String sql = "SELECT * FROM medico WHERE medico_id = '" + documento + "'";
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
	public void insertarMedico(Medico m) throws BusinessException {
		String sql = "INSERT INTO medico (medico_id, consultorio, nombre, apellido, especialidad) VALUES ('" + m.getDocumento() + "', '" + m.getConsultorio() + "', '" + m.getNombre()+ "', '" + m.getApellido() + "', '" + m.getEspecialidad()+ "')";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new BusinessException(BusinessException.TITULO, e.getMessage(), BusinessException.TYPE_SQL);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateMedicoByDocumento(Medico m) throws BusinessException{
		String sql = "UPDATE medico set consultorio = '" + m.getConsultorio() + "', nombre = '" + m.getNombre() + "', apellido = '" + m.getApellido() + "', especialidad = '" +m.getEspecialidad() + "' WHERE medico_id = '" + m.getDocumento() + "'";
		Connection c = DBManager.getDBManager().connect();
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
