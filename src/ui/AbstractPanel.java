package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTable;

import produccion.Handler;



public abstract class AbstractPanel extends JPanel {

	private JButton botonSalir;
	private Handler handler;
	
	private static final long serialVersionUID = 1L;

	public AbstractPanel(Handler handler) {
		this.handler=handler;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setSize(600,  400);
		this.setLocation(20,100);
		this.setVisible(true);
	}
	
	public JButton agregarSalirButton() {
		botonSalir= new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getHandler().executeSalirPanel();
			}
		});
		return botonSalir;
	}
	public Handler getHandler() {
		return handler;
	}
	

	
	public abstract void buttonDeleteAction(String matricula);
	public abstract void buttonCreateAction(String documento, String nombre, String apellido, String email);
	public abstract void buttonCreateAction(String documento, String consultorio, String nombre, String apellido,
			String especialidad);

	public abstract JTable getCustomJTable();

	

	

	
}
