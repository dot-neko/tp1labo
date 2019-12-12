package produccion;

import java.util.List;

import dao.MedicoDAO;
import entidades.Medico;
import excepciones.BusinessException;


public class MedicoBO {

	private MedicoDAO miDao;
	
	public MedicoBO(MedicoDAO miDao) {
		this.miDao = miDao;
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
			miDao.insertarMedico(m);
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
			miDao.deletemedicoByDocumento(String.valueOf(documento));
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	public List<Medico> getAllMedicos() throws BusinessException{
		List <Medico> medicos = null;
		medicos= miDao.getAllMedicos();
		
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
				m=miDao.getMedicoByDocumento(String.valueOf(documento));
				if (m==null) {
					m = new Medico(String.valueOf(documento));
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
			miDao.updateMedicoByDocumento(m);
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		
	}


	}
