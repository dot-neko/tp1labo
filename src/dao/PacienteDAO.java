package dao;

import java.util.List;

import entidades.Paciente;
import excepciones.BusinessException;

public interface PacienteDAO {

	//Pacientes
	public void insertarPacientes(Paciente p) throws BusinessException;
	public void deletePacienteByDocumento(String documento) throws BusinessException;
	public void updateUsuarioByDocumento(Paciente p) throws BusinessException;
	public Paciente getPacienteByDocumento(String documento) throws BusinessException;
	public List<Paciente> getAllPacientes() throws BusinessException;

}
