package dao;

import java.util.List;


import excepciones.BusinessException;

public interface TurnoDAO {

	public void CrearTurnosMedicos(int docmed, String turno, int consultorio, int reservado) throws BusinessException;
	public List<String> BuscarTurnos(int docmed) throws BusinessException;
	public void ReservaTurno(int docmed, String turno, int docpac, int reservado) throws BusinessException;
	
}
