package consoleImpl;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Collection;

//import basics.DBManager;

import dao.UsuarioDAO;
import entidades.Pacientes;

public class UsuarioDAOConsoleImpl implements UsuarioDAO{


	@Override
	public Collection<?> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertarPacientes(Pacientes p) {
		String sql = "INSERT INTO pacientes (nom, ape, mail) VALUES ('" + p.getNombre() + "', '" + p.getApellido() + "', '" + p.getEmail()+ "')";
		System.out.println("Deberias tirar la siguiente consulta a la DB:" + sql);
		
	}

	@Override
	public void deletePacienteByDocumento(int documento) {
		String sql = "DELETE FROM pacientes WHERE documento = '" + documento + "'";
		System.out.println("Deberias tirar la siguiente consulta a la DB:" + sql);
		
	}

	@Override
	public void updateUsuarioByDocumento(int documento, Pacientes p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pacientes getPacienteByDocumento(int documento) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
