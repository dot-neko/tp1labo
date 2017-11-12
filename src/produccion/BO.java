package produccion;

import java.util.List;

import javax.swing.JOptionPane;

import dbImpl.UsuarioDAODBImpl;
import entidades.Pacientes;


public class BO {

	private UsuarioDAODBImpl dao = new UsuarioDAODBImpl();
	Pacientes pacientes;
	public void llamarDAO(){
		//Llama a DAO
		System.out.println("Llamando a DAO");
	}
	public void ValidarPacienteNuevo(int documento, String nombre, String apellido, String email){
		//Llama a DAO
		System.out.println("Validando documento");
		if (documento >0 && documento<100000000) {
			pacientes=new Pacientes(documento,nombre,apellido,email);
			dao.insertarPacientes(pacientes);
			JOptionPane.showMessageDialog(null, "Se ingreso: "+ documento + nombre + apellido);
		}else{
			System.out.println("Fallo");
		}
	}/*
	public void insertarPedido(Pedido p) throws BusinessException {
		dao.insertarPedido(p);
	}

	public void deleteUsuarioById(String idPedido) throws BusinessException {
		dao.deletePedidoByIdPedido(idPedido);
	}

	public void updatePedido(Pedido p) {
		dao.updatePedido(p);
	}

	public Pedido getPedidoByIdPedido(Integer id) {
		return dao.getPedidoByIdPedido(id);
	}
*/
	public List<Pacientes> getAllPacientes() {
		return dao.getAllPacientes();
	}
/*
	public void setDao(PedidoDAO dao) {
		this.dao = dao;
	}*/

}
