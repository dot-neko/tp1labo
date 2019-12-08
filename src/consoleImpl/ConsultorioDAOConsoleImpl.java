package consoleImpl;


import java.util.List;
import dao.ConsultorioDAO;
import entidades.Medico;
import entidades.Paciente;
import entidades.Turnos;
import excepciones.BusinessException;

public class ConsultorioDAOConsoleImpl implements ConsultorioDAO{


	@Override
	public List<Paciente> getAllPacientes() {
		
		return null;
	}


	@Override
	public void insertarPacientes(Paciente p) {
		String sql = "INSERT INTO pacientes (nom, ape, mail) VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
		System.out.println("Deberias tirar la siguiente consulta a la DB:" + sql);
		
	}

	@Override
	public void deletePacienteByDocumento(String documento) {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
		System.out.println("Deberias tirar la siguiente consulta a la DB:" + sql);
		
	}

	@Override
	public void updateUsuarioByDocumento(Paciente p) {
		
		
	}

	@Override
	public Paciente getPacienteByDocumento(String documento) {
		
		return null;
	}


	@Override
	public void updateMedicoByDocumento(Medico m) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deletemedicoByDocumento(String documento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Medico> getAllMedicos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Medico getMedicoByDocumento(String documento) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertarMedico(Medico m) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CrearTurnosMedicos(Turnos turno) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	
	
}
