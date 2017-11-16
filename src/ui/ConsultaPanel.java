package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import entidades.Pacientes;



public class ConsultaPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List <Pacientes> listadoPacientes;

	public ConsultaPanel(List<Pacientes> listapacientes){
		this.setLayout(new BorderLayout());
		JTable tablaconsulta = new JTable(new PacienteTableModel(listapacientes));
		JScrollPane pane = new JScrollPane(tablaconsulta);
		this.add(pane, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
}
