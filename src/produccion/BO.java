package produccion;

import java.util.List;

import javax.swing.JOptionPane;

import dao.PacienteDAO;
import entidades.Paciente;
import excepciones.BusinessException;


public class BO {

	PacienteDAO miDao;
	
	public BO(PacienteDAO miDao) {
		this.miDao = miDao;
	}
	

	public void ValidarPacienteNuevo(Paciente p) throws BusinessException, Exception{
		//Llama a DAO
		System.out.println("Validando documento");
		//TODO: TRY//CATCH
			int documento= p.getDocumento();
			if (documento >0 && documento<100000000) {
				miDao.insertarPacientes(p);
				JOptionPane.showMessageDialog(null, "Se ingreso Paciente correctamente.");
			}else{
				JOptionPane.showMessageDialog(null, "Error al ingresar documento. Intente de nuevo.");
				System.out.println("Fallo");
			}
	}
	
	public void validarPacientebyDocumento(Paciente p) throws BusinessException {
		int documento= p.getDocumento();
		try {
			if (documento>0 && documento<100000000) {
				miDao.deletePacienteByDocumento(documento);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ingreso: "+ documento + ". No puede ser mayor a 100.000.000 o negativo");
			e.printStackTrace();
		}
	}
	public List<Paciente> getAllPacientes(){
		List <Paciente> pac = null;
		try {
			pac= miDao.getAllPacientes();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pac;
	}
	public Paciente validarPacienteporBusqueda(Paciente p) throws BusinessException {
			int documento= p.getDocumento();
			p=miDao.getPacienteByDocumento(documento);
		return p;
	}
	public void updatePaciente(Paciente p) throws BusinessException {
		miDao.updateUsuarioByDocumento(p);
	}
/*
	public void insertarPaciente(Paciente p) throws BusinessException {
		dao.insertarPaciente(p);
	}
*/
}
