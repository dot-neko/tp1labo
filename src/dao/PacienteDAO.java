package dao;

import java.util.List;

import entidades.Paciente;
import excepciones.BusinessException;

public interface PacienteDAO {

	//Pacientes
	public void insertarPacientes(int documento, String nombre, String apellido, String email) throws BusinessException;
	public void deletePacienteByDocumento(int documento) throws BusinessException;
	public void updateUsuarioByDocumento(int documento, String nombre, String apellido, String email) throws BusinessException;
	public Paciente getPacienteByDocumento(int documento) throws BusinessException;
	public List<Paciente> getAllPacientes() throws BusinessException;

}
