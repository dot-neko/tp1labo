package produccion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.TurnoDAO;
import entidades.Turno;
import excepciones.BusinessException;


public class TurnoBO {

	private TurnoDAO miDao;

	public TurnoBO(TurnoDAO turnoDao) {
		this.miDao = turnoDao;
	}


	public void crearTurnosNuevo(Turno turno) throws BusinessException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		Date turnohora;
		int diaslimite = 12; //dias a futuro para ofrecer turnos
		
		turnohora=parseFechaHora(turno.getfechaHora());
		Calendar cal= Calendar.getInstance();
		cal.setTime(turnohora);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		cal.set(year, month, day, 8, 0);//FORMATO INICIAL
		
		for (int i = 0; i < diaslimite; i++) {
			turnohora=cal.getTime();
			turno.setFecha_hora(df.format(turnohora));
			miDao.CrearTurnosMedicos(Integer.valueOf(turno.getdocumentoMedico()),
					turno.getfechaHora(),
					Integer.valueOf(turno.getConsultorio()),
					Integer.valueOf(turno.getReservado()));
			cal.add(Calendar.MINUTE, 30);//Suma intervalos de 30 minutos
		}
	}


	public List<Date> buscarTurnosLibres(Turno buscaturno) throws BusinessException  {
		List<Date> retornalistafechas = new ArrayList<Date>() ;
		List<String> turnoslibresStr;
		Date turnofechahora;
		
		turnoslibresStr=miDao.BuscarTurnos(Integer.valueOf(buscaturno.getdocumentoMedico()));

		for (String strFechaHora : turnoslibresStr) {
			turnofechahora=parseFechaHora(strFechaHora);
			retornalistafechas.add(turnofechahora);
		}
		return retornalistafechas;
	}


	public void reservaTurno(Turno turno) throws BusinessException {
		miDao.ReservaTurno(Integer.valueOf(turno.getdocumentoMedico()),
				turno.getfechaHora(),
				Integer.valueOf(turno.getdocumentoPaciente()),
				Integer.valueOf(turno.getReservado()));
	}
	
	private Date parseFechaHora(String strFechaHora) throws BusinessException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		Date returnDate;
		try {
			returnDate = df.parse(strFechaHora);
		} catch (ParseException e) {
			throw new BusinessException(BusinessException.TITULO,e.getMessage(),BusinessException.GENERICO);
		}
		return returnDate;
		
	}
}
