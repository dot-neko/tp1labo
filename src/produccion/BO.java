package produccion;

import java.util.List;

import javax.swing.JOptionPane;

import dbImpl.UsuarioDAODBImpl;
import entidades.Pacientes;
import excepciones.BusinessException;


public class BO {

	private UsuarioDAODBImpl dao = new UsuarioDAODBImpl();
	Pacientes pacientes;

	public void ValidarPacienteNuevo(int documento, String nombre, String apellido, String email){
		//Llama a DAO
		System.out.println("Validando documento");
		//TODO: TRY//CATCH
		if (documento >0 && documento<100000000) {
			pacientes=new Pacientes(documento,nombre,apellido,email);
			dao.insertarPacientes(pacientes);
			JOptionPane.showMessageDialog(null, "Se ingreso: "+ documento + nombre + apellido);
		}else{
			System.out.println("Fallo");
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
/*
	public void insertarPedido(Pedido p) throws BusinessException {
		dao.insertarPedido(p);
	}

	
	public void updatePedido(Pedido p) {
		dao.updatePedido(p);
	}

	public Pedido getPedidoByIdPedido(Integer id) {
		return dao.getPedidoByIdPedido(id);
	}

	public void setDao(PedidoDAO dao) {
		this.dao = dao;
	}*/

}
