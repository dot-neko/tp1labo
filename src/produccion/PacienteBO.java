package produccion;

import java.util.List;

import dao.PacienteDAO;
import entidades.Paciente;
import excepciones.BusinessException;


public class PacienteBO {

	private PacienteDAO miDao;

	public PacienteBO(PacienteDAO pacienteDao) {
		this.miDao = pacienteDao;
	}

	public void IngresarPacienteNuevo(Paciente p) throws BusinessException{

		int documento = validarDocumentoPaciente(p.getDocumento());
		miDao.insertarPacientes(documento,p.getNombre(),p.getApellido(),p.getEmail());

	}

	public void borrarPacientebyDocumento(Paciente p) throws BusinessException {
		
		int documento = validarDocumentoPaciente(p.getDocumento());
		miDao.deletePacienteByDocumento(documento);
	}


	public List<Paciente> getAllPacientes() throws BusinessException{
		
		List <Paciente> pac = null;
		pac= miDao.getAllPacientes();
		return pac;
	}

	public Paciente obtenerPacienteporBusqueda(Paciente p) throws BusinessException {
		
		int documento = validarDocumentoPaciente(p.getDocumento());
		p=miDao.getPacienteByDocumento(documento);
		p=validarPaciente(p,documento);
		return p;
	}
	
	public void updatePaciente(Paciente p) throws BusinessException {
		int documento = validarDocumentoPaciente(p.getDocumento());
		miDao.updateUsuarioByDocumento(documento,p.getNombre(),p.getApellido(),p.getEmail());
	}

	
	private int validarDocumentoPaciente(String doc)throws BusinessException{
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

	private Paciente validarPaciente(Paciente p, int documento) {
		if (p==null) {
			p = new Paciente(String.valueOf(documento));
		}
		return p;
	}
}
