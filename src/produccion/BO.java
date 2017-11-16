package produccion;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dbImpl.UsuarioDAODBImpl;
import entidades.Pacientes;
import excepciones.BusinessException;


public class BO {

	private UsuarioDAODBImpl dao = new UsuarioDAODBImpl();
	Pacientes pacientes;

	public void ValidarPacienteNuevo(int documento, String nombre, String apellido, String email) throws BusinessException, SQLException{
		//Llama a DAO
		System.out.println("Validando documento");
		//TODO: TRY//CATCH
		try {
			if (documento >0 && documento<100000000) {
				pacientes=new Pacientes(documento,nombre,apellido,email);
				dao.insertarPacientes(pacientes);
				JOptionPane.showMessageDialog(null, "Se ingreso: Documento " + documento +", Nombre :"+ nombre + ", Apellido :"+ apellido);
			}else{
				System.out.println("Fallo");
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validarPacientebyDocumento(int documento) throws BusinessException {
		try {
			if (documento >0 && documento<100000000) {
				dao.deletePacienteByDocumento(documento);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ingreso: "+ documento + ". No puede ser mayor a 100.000.000 o negativo");
			e.printStackTrace();
		}
	}
	public List<Pacientes> getAllPacientes() {
		return dao.getAllPacientes();
	}
	public Pacientes validarPacienteporBusqueda(Integer documento) {
		return dao.getPacienteByDocumento(documento);
	}
/*
	public void insertarPaciente(Paciente p) throws BusinessException {
		dao.insertarPaciente(p);
	}

	
	public void updatePaciente(Paciente p) {
		dao.updatePaciente(p);
	}

	

	public void setDao(PacienteDAO dao) {
		this.dao = dao;
	}*/

}
