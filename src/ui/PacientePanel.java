package ui;

import java.util.List;

import javax.swing.JTable;

import entidades.Paciente;
import produccion.Handler;

public abstract class PacientePanel extends AbstractPanel {


	private static final long serialVersionUID = 1L;

	public static JTable getPacienteJTable (Handler handler) {
		List<Paciente> pacienteList  = handler.obtenerPacientes();
		JTable jtable = new JTable(new PacienteTableModel(pacienteList));
		return jtable;
	}
	protected static void buttonDeleteAction(Handler handler, String matricula) {
		Paciente p= new Paciente(matricula);
		handler.borrarPacienteByDocumento(p);
	}
	protected static void buttonCreatePaciente(Handler handler,String documento, String nombre, String apellido, String email) {
		Paciente p= new Paciente(documento, nombre, apellido, email);
		handler.IngresarPacienteCompleto(p);
	}
	protected static Paciente buttonSearchPaciente(Handler handler,String documento){
		Paciente p= new Paciente(documento);
		return handler.buscarPaciente(p);
	}
	protected static void buttonUpdatePaciente(Handler handler,String documento, String nombre, String apellido, String email) {
		Paciente p= new Paciente(documento, nombre, apellido, email);
		handler.IngresarPacienteCompleto(p);
	}
}