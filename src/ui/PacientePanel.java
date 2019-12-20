package ui;

import java.util.List;

import javax.swing.JTable;

import entidades.Paciente;
import produccion.Handler;

public abstract class PacientePanel extends AbstractPanel {


	public PacientePanel(Handler handler) {
		super(handler);
	}
	private static final long serialVersionUID = 1L;

	@Override
	public JTable getCustomJTable () {
		List<Paciente> pacienteList  = getHandler().obtenerPacientes();
		JTable jtable = new JTable(new PacienteTableModel(pacienteList));
		return jtable;
	}
	@Override
	public void buttonDeleteAction(String matricula) {
		Paciente p= new Paciente(matricula);
		getHandler().borrarPacienteByDocumento(p);
	}
	@Override
	public void buttonCreateAction(String documento, String nombre, String apellido, String email) {
		Paciente p= new Paciente(documento, nombre, apellido, email);
		getHandler().IngresarPacienteCompleto(p);
	}

	protected Paciente buttonSearchPac(String documento){
		Paciente p= new Paciente(documento);
		return getHandler().buscarPaciente(p);
	}
	protected  void buttonUpdatePac(String documento, String nombre, String apellido, String email) {
		Paciente p= new Paciente(documento, nombre, apellido, email);
		getHandler().IngresarPacienteCompleto(p);
	}
	protected abstract void setAction();
	
	@Override
	public void buttonCreateAction(String documento, String consultorio, String nombre, String apellido,
			String especialidad) {	
	}
}