package dao;

import java.util.List;


import excepciones.BusinessException;

public interface TurnoDAO {

	public void CrearTurnosMedicos(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException;
	public List<String> BuscarTurnos(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException;
	public void ReservaTurno(int docmed, String turno, int docpac, int consultorio, int reservado) throws BusinessException;
	
}
