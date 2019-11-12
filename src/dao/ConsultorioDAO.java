package dao;

import java.sql.SQLException;
import java.util.List;

import entidades.Medico;
import entidades.Paciente;
import excepciones.BusinessException;

public interface ConsultorioDAO {

	//Pacientes
	public void insertarPacientes(Paciente p) throws SQLException;
	public void deletePacienteByDocumento(String documento) throws SQLException;
	public void updateUsuarioByDocumento(Paciente p) throws SQLException;
	public Paciente getPacienteByDocumento(String documento) throws SQLException;
	public List<Paciente> getAllPacientes() throws SQLException;
	//Medicos
	public void updateMedicoByDocumento(Medico m) throws BusinessException, SQLException;
	public void deletemedicoByDocumento(String documento) throws BusinessException, SQLException;
	public List<Medico> getAllMedicos() throws SQLException;
	public Medico getMedicoByDocumento(String documento) throws BusinessException, SQLException;
	public void insertarMedico(Medico m) throws SQLException;
	
}
