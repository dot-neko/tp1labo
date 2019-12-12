package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Medico;
import produccion.Handler;



public class ConsultaPanelMedico extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	List <Medico> listadomedicos;
	private Handler handler;

	public ConsultaPanelMedico(Handler handler){
		this.handler=handler;

		listadomedicos=getHandler().obtenerTodosMedicos();

		this.setLayout(new BorderLayout());
		JTable tablaconsulta = new JTable(new MedicoTableModel(listadomedicos));
		JScrollPane pane = new JScrollPane(tablaconsulta);
		this.add(pane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public Handler getHandler() {
		return handler;
	}


}
