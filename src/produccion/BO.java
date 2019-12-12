package produccion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ConsultorioDAO;
import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
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
				miDao.insertarPacientes(p);
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
			miDao.deletePacienteByDocumento(String.valueOf(documento));
		}else {
			throw new BusinessException(BusinessException.TITULO,BusinessException.ERRNUMEROINVALIDO,BusinessException.GENERICO);
		}
	}
	
	
	public List<Paciente> getAllPacientes() throws BusinessException{
		List <Paciente> pac = null;
		pac= miDao.getAllPacientes();
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
					if (p==null) {
						p = new Paciente(String.valueOf(documento));
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
			miDao.updateUsuarioByDocumento(p);
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


	public void CrearTurnosMedico(Turno turno) throws BusinessException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		Date turnohora = null;
		try {
			turnohora = df.parse(turno.getFecha_hora());
		} catch (ParseException e1) {
			throw new BusinessException(BusinessException.TITULO, e1.getMessage(), BusinessException.GENERICO);
		}
		Calendar cal= Calendar.getInstance();
		cal.setTime(turnohora);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.set(year, month, day, 8, 0);//FORMATO INICIAL
		for (int i = 0; i < 12; i++) {
			turnohora=cal.getTime();
			turno.setFecha_hora(df.format(turnohora));
			miDao.CrearTurnosMedicos(turno);
			cal.add(Calendar.MINUTE, 30);
			
		}
	}


	public List<Date> BuscarTurnosLibres(Turno buscaturno) throws BusinessException  {
		List<Date> retornalistafechas = new ArrayList<Date>() ;
		List<String> turnoslibresStr = null;
		Date turnofechahora = null;
		turnoslibresStr=miDao.BuscarTurnos(buscaturno);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		
		for (String stringfechahora : turnoslibresStr) {
			try {
				turnofechahora = df.parse(stringfechahora);
			} catch (ParseException e) {
				throw new BusinessException(BusinessException.TITULO,e.getMessage(),BusinessException.GENERICO);
			}
			retornalistafechas.add(turnofechahora);
		}
		return retornalistafechas;
		
	}


	public void ReservaTurno(Turno turno) throws BusinessException {
		miDao.ReservaTurno(turno);
		}
}
