package ui;

import java.util.List;

import javax.swing.JTable;

import entidades.Medico;
import produccion.Handler;

public abstract class MedicoPanel extends AbstractPanel {

	public MedicoPanel(Handler handler) {
		super(handler);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public JTable getCustomJTable () {
		List<Medico> medicoList  = getHandler().obtenerTodosMedicos();
		JTable jtable = new JTable(new MedicoTableModel(medicoList));
		return jtable;
	}
	@Override
	public void buttonDeleteAction(String matricula) {
		Medico m= new Medico(matricula);
		getHandler().borrarMedicoByDocumento(m);
	}
	@Override
	public void buttonCreateAction(String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		Medico m = new Medico(documento, consultorio, nombre, apellido, especialidad);
		getHandler().ingresarMedicoCompleto(m);
	}
	
	public  Medico buttonSearchMed(String documento) {
		Medico m= new Medico(documento);
		return getHandler().buscarMedico(m);
	}
	public  void buttonUpdateMedico(String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		Medico m = new Medico(documento, consultorio, nombre, apellido, especialidad);
		getHandler().ingresarMedicoCompleto(m);
	}
	protected abstract void setAction();
	
	@Override
	public void buttonCreateAction(String documento, String nombre, String apellido, String email) {
	}
}
