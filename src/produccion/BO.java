package produccion;
import java.util.List;

import dao.ConsultorioDAO;
import entidades.Medico;
import entidades.Paciente;
import excepciones.BusinessException;


public class BO {

	private ConsultorioDAO miDao;
	
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
				} catch (BusinessException e) {
					throw e;
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
			} catch (BusinessException e) {
				throw e;
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	
	public List<Paciente> getAllPacientes() throws BusinessException{
		List <Paciente> pac = null;
		try {
			pac= miDao.getAllPacientes();
		} catch (BusinessException e) {
			throw e;
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
					if (p==null) {
						p = new Paciente(String.valueOf(documento));
					}
				} catch (BusinessException e) {
					throw e;
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
			} catch (BusinessException e) {
				throw e;
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		
	}
	
	
	//medicos
	
	public void ValidarMedicoNuevo(Medico m) throws BusinessException{
		
		int documento;
		
		try {
			documento = Integer.valueOf(m.getDocumento());
		} catch (NumberFormatException e1) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
		
		if (documento >0 && documento<100000000) {
			try {
				miDao.insertarMedico(m);
			} catch (BusinessException e) {
				throw e;
			}
		}
		else{
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		}
	
	public void validarMedicobyDocumento(Medico p) throws BusinessException {
		int documento;
		try {
			documento = Integer.valueOf(p.getDocumento());
		} catch (NumberFormatException e1) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
		if (documento>0 && documento<100000000) {
			try {
				miDao.deletemedicoByDocumento(String.valueOf(documento));
			} catch (BusinessException e) {
				throw e;
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	public List<Medico> getAllMedicos() throws BusinessException{
		List <Medico> medicos = null;
		try {
			medicos= miDao.getAllMedicos();
		} catch (BusinessException e) {
			throw e;
		}
		return medicos;
	}
	

	public Medico validarMedicoporBusqueda(Medico m) throws BusinessException {
			int documento;
			try {
				documento = Integer.valueOf(m.getDocumento());
			} catch (NumberFormatException e) {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
			}
			if (documento>0 && documento<100000000) {
				try {
					m=miDao.getMedicoByDocumento(String.valueOf(documento));
					if (m==null) {
						m = new Medico(String.valueOf(documento));
					}
				} catch (BusinessException e) {
					throw e;
				}
			}else {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
			
		return m;
	}
	public void updateMedico(Medico m) throws BusinessException {
		int documento;
		try {
			documento = Integer.valueOf(m.getDocumento());
		} catch (NumberFormatException e) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
		if (documento>0 && documento<100000000) {
			try {
				miDao.updateMedicoByDocumento(m);
			} catch (BusinessException e) {
				throw e;
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		
	}
}
