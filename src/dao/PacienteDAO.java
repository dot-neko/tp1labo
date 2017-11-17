package dao;

import java.util.List;

import entidades.Paciente;
import excepciones.BusinessException;

public interface PacienteDAO {

	public void insertarPacientes(Paciente p) throws BusinessException;
	public void deletePacienteByDocumento(int documento) throws BusinessException;
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException;
	public Paciente getPacienteByDocumento(int documento) throws BusinessException;
	public List<Paciente> getAllPacientes() throws BusinessException;
	
}
