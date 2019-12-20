package ui;

import java.util.List;

import javax.swing.JTable;

import entidades.Medico;
import produccion.Handler;

public abstract class MedicoPanel extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	
	
	public static JTable getMedicoJTable (Handler handler) {
		List<Medico> medicoList  = handler.obtenerTodosMedicos();
		JTable jtable = new JTable(new MedicoTableModel(medicoList));
		return jtable;
	}
	public static void buttonDeleteAction(Handler handler,String matricula) {
		Medico m= new Medico(matricula);
		handler.borrarMedicoByDocumento(m);
	}
	public static void buttonCreateMedico(Handler handler, String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		Medico m = new Medico(documento, consultorio, nombre, apellido, especialidad);
		handler.ingresarMedicoCompleto(m);
	}
	public static Medico buttonSearchMedico(Handler handler,String documento) {
		Medico m= new Medico(documento);
		return handler.buscarMedico(m);
	}
	public static void buttonUpdateMedico(Handler handler,String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		Medico m = new Medico(documento, consultorio, nombre, apellido, especialidad);
		handler.ingresarMedicoCompleto(m);
	}
}
