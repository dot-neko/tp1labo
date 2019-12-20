package ui;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import produccion.Handler;



public class ConsultaPanel extends AbstractPanel {
	private Handler handler;
	private static final long serialVersionUID = 1L;

	
	public ConsultaPanel(Handler handler){
		this.handler=handler;
	}
	public void setAction(MedicoPanel mp) {
		JTable jtable = MedicoPanel.getMedicoJTable(handler);
		JScrollPane pane = new JScrollPane(jtable);
		this.add(pane);
	}
	public void setAction(PacientePanel pp) {
		JTable jtable = PacientePanel.getPacienteJTable(handler);
		JScrollPane pane = new JScrollPane(jtable);
		this.add(pane);
	}
	public Handler getHandler() {
		return handler;
	}
}
