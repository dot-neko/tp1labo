package dao;

import java.util.List;

import entidades.Medico;
import excepciones.BusinessException;

public interface MedicoDAO {

	public void updateMedicoByDocumento(Medico m) throws BusinessException;
	public void deletemedicoByDocumento(String documento) throws BusinessException;
	public List<Medico> getAllMedicos() throws BusinessException;
	public Medico getMedicoByDocumento(String documento) throws BusinessException;
	public void insertarMedico(Medico m) throws BusinessException;
	
}
