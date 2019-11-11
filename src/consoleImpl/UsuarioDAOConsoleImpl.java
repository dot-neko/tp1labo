package consoleImpl;


import java.util.List;
import dao.PacienteDAO;
import entidades.Paciente;

public class UsuarioDAOConsoleImpl implements PacienteDAO{


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

	
	
}
