package dao;

import java.sql.SQLException;
import java.util.List;

import entidades.Paciente;
import excepciones.BusinessException;

public interface PacienteDAO {

	public void insertarPacientes(Paciente p) throws BusinessException, SQLException;
	public void deletePacienteByDocumento(String documento) throws BusinessException, SQLException;
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException, SQLException;
	public Paciente getPacienteByDocumento(String documento) throws BusinessException;
	public List<Paciente> getAllPacientes() throws SQLException;
	
}
