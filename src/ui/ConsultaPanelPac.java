package ui;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import produccion.Handler;



public class ConsultaPanelPac extends PacientePanel {
	private static final long serialVersionUID = 1L;

	
	public ConsultaPanelPac(Handler handler){
		super(handler);
	}
	@Override
	protected void setAction() {
		JTable jtable = getCustomJTable();
		JScrollPane pane = new JScrollPane(jtable);
		this.add(pane);
	}
	
}
