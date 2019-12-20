package dao;

import java.util.List;

import entidades.Medico;
import excepciones.BusinessException;

public interface MedicoDAO {

	public void updateMedicoByDocumento(int documento, int consultorio, String nombre, String apellido, String especialidad) throws BusinessException;
	public void deletemedicoByDocumento(int documento) throws BusinessException;
	public List<Medico> getAllMedicos() throws BusinessException;
	public Medico getMedicoByDocumento(int documento) throws BusinessException;
	public void insertarMedico(int documento, int consultorio, String nombre, String apellido, String especialidad) throws BusinessException;
	
}
