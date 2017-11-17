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

	@Override
	public void deletePacienteByDocumento(int documento) throws BusinessException {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
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
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		}
	}

	@Override
	public List<Paciente> getAllPacientes() throws BusinessException {
		Paciente paciente = null;
		List<Paciente> respuesta = new ArrayList<Paciente>();
		String sql = "SELECT * FROM pacientes";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			c.commit();
			while (rs.next()) {
				Integer id =  rs.getInt("documento");
				String n = rs.getString("nombre");
				String a = rs.getString("apellido");
				String e = rs.getString("email");
				paciente = new Paciente();
				paciente.setDocumento(id);
				paciente.setNombre(n);
				paciente.setApellido(a);
				paciente.setEmail(e);
				respuesta.add(paciente);
			}

		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//TODO: Agregar a Exception
				System.out.println("No se pudo restaurar los datos");
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//TODO: Agregar a Exception
				System.out.println("No se pudo cerrar la conexion a la DB");
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		}
		return respuesta;

	}

	@Override
	public Paciente getPacienteByDocumento(int documento) throws BusinessException {
		Paciente retorna = null;
		String sql = "SELECT * FROM pacientes WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String n = rs.getString("nombre");
				String a = rs.getString("apellido");
				String e = rs.getString("email");
				retorna = new Paciente(documento, n, a, e);
				retorna.setDocumento(documento);
				retorna.setNombre(n);
				retorna.setApellido(a);
				retorna.setEmail(e);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		} finally {
			try {
				c.commit();
				c.close();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		}
		return retorna;
	}




	@Override
	public void insertarPacientes(Paciente p) throws BusinessException {
		String sql = "INSERT INTO pacientes (documento, nombre, apellido, email) VALUES ('" + p.getDocumento() + "', '" + p.getNombre()+ "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
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
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException  {
		int documento= p.getDocumento();
		String sql = "UPDATE pacientes set nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido() + "', email = '" + p.getEmail() + "' WHERE documento = '" + documento + "'";
		Connection c = DBManager.getDBManager().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.MENSAJE,BusinessException.GENERICO);
			}
		}
		
	}

	
	
}
