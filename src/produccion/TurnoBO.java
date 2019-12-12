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
