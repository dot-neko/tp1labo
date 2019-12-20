package consoleImpl;


import java.util.List;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.TurnoDAO;
import entidades.*;
import excepciones.BusinessException;

public class ConsultorioDAOConsoleImpl implements MedicoDAO, PacienteDAO, TurnoDAO{


	@Override
	public List<Paciente> getAllPacientes() {
		
		return null;
	}


	@Override
	public void insertarPacientes(int documento, String nombre, String apellido, String email) {

	}

	@Override
	public void deletePacienteByDocumento(int documento) {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
		System.out.println("Deberias tirar la siguiente consulta a la DB:" + sql);
		
	}

	@Override
	public void updateUsuarioByDocumento(int documento, String nombre, String apellido, String email) {
		
		
	}

	@Override
	public Paciente getPacienteByDocumento(int documento) {
		
		return null;
	}




	@Override
	public void deletemedicoByDocumento(int documento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Medico> getAllMedicos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Medico getMedicoByDocumento(int documento) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateMedicoByDocumento(int documento, int consultorio, String nombre, String apellido,
			String especialidad) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertarMedico(int documento, int consultorio, String nombre, String apellido, String especialidad)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CrearTurnosMedicos(int docmed, String turno, int consultorio, int reservado) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> BuscarTurnos(int docmed) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void ReservaTurno(int docmed, String turno, int docpac, int reservado) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	
	
}
