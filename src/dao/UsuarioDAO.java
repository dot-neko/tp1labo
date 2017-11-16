package dao;

import java.sql.SQLException;
import java.util.List;

import entidades.Pacientes;
import excepciones.BusinessException;

public interface UsuarioDAO {

	public void insertarPacientes(Pacientes p) throws BusinessException, SQLException;
	public void deletePacienteByDocumento(int documento);
	public void updateUsuarioByDocumento(int documento, Pacientes p);
	public Pacientes getPacienteByDocumento(int documento);
	public List<Pacientes> getAllPacientes();
	
}
