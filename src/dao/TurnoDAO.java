package dao;

import java.util.List;

import entidades.Turno;
import excepciones.BusinessException;

public interface TurnoDAO {

	public void CrearTurnosMedicos(Turno turno) throws BusinessException;
	public List<String> BuscarTurnos(Turno buscaturno) throws BusinessException;
	public void ReservaTurno(Turno turno) throws BusinessException;
	
}
