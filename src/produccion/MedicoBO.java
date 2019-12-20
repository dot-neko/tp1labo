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
	
	public void ingresarMedicoNuevo(Medico m) throws BusinessException{
		int documento = validarDocumentoMedico(m.getDocumento());
		miDao.insertarMedico(documento,Integer.valueOf(m.getConsultorio()),m.getNombre(),m.getApellido(),m.getEspecialidad());
		
	}
	
	public void borrarMedicoporDocumento(Medico m) throws BusinessException {
		int documento = validarDocumentoMedico(m.getDocumento());
		miDao.deletemedicoByDocumento(documento);
		
	}
	
	public List<Medico> getAllMedicos() throws BusinessException{
		List <Medico> medicos = null;
		medicos= miDao.getAllMedicos();
		return medicos;
	}
	

	public Medico obtenerMedicoporDocumento(Medico m) throws BusinessException {
		int documento = validarDocumentoMedico(m.getDocumento());
		m=miDao.getMedicoByDocumento(documento);
		m=validarMedico(m, documento);
		return m;
	}
	public void updateMedico(Medico m) throws BusinessException {
		int documento = validarDocumentoMedico(m.getDocumento());
		miDao.updateMedicoByDocumento(documento,Integer.valueOf(m.getConsultorio()),m.getNombre(),m.getApellido(),m.getEspecialidad());
	}

	private int validarDocumentoMedico(String doc)throws BusinessException{
		try {
			int documento = Integer.valueOf(doc);
			if (documento >0 && documento<100000000) {
				return documento;
			}
			else{
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
		} catch (NumberFormatException e1) {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMERO,BusinessException.GENERICO);
		}
	}

	private Medico validarMedico(Medico m, int documento) {
		if (m==null) {
			m = new Medico(String.valueOf(documento));
		}
		return m;
	}

}
