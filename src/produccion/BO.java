package produccion;

import java.sql.SQLException;
import java.util.List;

import dao.PacienteDAO;
import entidades.Paciente;
import excepciones.BusinessException;


public class BO {

	PacienteDAO miDao;
	Handler handler;
	
	public BO(Handler handler, PacienteDAO miDao) {
		this.miDao = miDao;
		this.handler = handler;
	}
	

	public void ValidarPacienteNuevo(Paciente p) throws BusinessException, Exception{
		
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
					throw new SQLException();
				}
				handler.IngresoPacienteOk();
			}
			else{
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
	}
	
	public void validarPacientebyDocumento(Paciente p) throws BusinessException, SQLException {
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
				throw new SQLException();
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	
	public List<Paciente> getAllPacientes() throws SQLException{
		List <Paciente> pac = null;
		try {
			pac= miDao.getAllPacientes();
		} catch (SQLException e) {
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
				p=miDao.getPacienteByDocumento(String.valueOf(documento));
			}else {
				throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
			}
			
		return p;
	}
	public void updatePaciente(Paciente p) throws BusinessException, SQLException {
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
				throw e;
			}
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
		
	}
/*
	public void insertarPaciente(Paciente p) throws BusinessException {
		dao.insertarPaciente(p);
	}
*/
}
