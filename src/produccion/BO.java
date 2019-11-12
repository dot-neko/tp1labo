package produccion;

import java.sql.SQLException;
import java.util.List;

import dao.ConsultorioDAO;
import entidades.Paciente;
import excepciones.BusinessException;


public class BO {

	ConsultorioDAO miDao;
	
	public BO(ConsultorioDAO miDao) {
		this.miDao = miDao;
	}
	

	public void ValidarPacienteNuevo(Paciente p) throws BusinessException{
		
			int documento;
			
			try {
				documento = Integer.valueOf(p.getDocumento());
			} catch (NumberFormatException e1) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
			}
			
			if (documento >0 && documento<100000000) {
				try {
					miDao.insertarPacientes(p);
				} catch (SQLException e) {
					throw new BusinessException(BusinessException.TITULO,e.getMessage(),BusinessException.GENERICO);
				}
			}
			else{
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
	}
	
	public void validarPacientebyDocumento(Paciente p) throws BusinessException {
		int documento;
		try {
			documento = Integer.valueOf(p.getDocumento());
		} catch (NumberFormatException e1) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
		if (documento>0 && documento<100000000) {
			try {
				miDao.deletePacienteByDocumento(String.valueOf(documento));
			} catch (SQLException e) {
				//TODO
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	
	public List<Paciente> getAllPacientes() throws BusinessException{
		List <Paciente> pac = null;
		try {
			pac= miDao.getAllPacientes();
		} catch (SQLException e) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRDBGET,BusinessException.GENERICO);
		}
		return pac;
	}
	
	
	public Paciente validarPacienteporBusqueda(Paciente p) throws BusinessException {
			int documento;
			try {
				documento = Integer.valueOf(p.getDocumento());
			} catch (NumberFormatException e) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
			}
			if (documento>0 && documento<100000000) {
				try {
					p=miDao.getPacienteByDocumento(String.valueOf(documento));
				} catch (SQLException e) {
					throw new BusinessException(BusinessException.TITULO,BusinessException.ERRDBGET,BusinessException.GENERICO);
				}
			}else {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
			
		return p;
	}
	public void updatePaciente(Paciente p) throws BusinessException {
		int documento;
		try {
			documento = Integer.valueOf(p.getDocumento());
		} catch (NumberFormatException e) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
		if (documento>0 && documento<100000000) {
			try {
				miDao.updateUsuarioByDocumento(p);
			} catch (SQLException e) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRDB,BusinessException.GENERICO);
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		
	}
}
