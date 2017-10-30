package ui;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PruebaPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		createLabelTextfield("Nombre :", 30);
		createLabelTextfield("Apellido :", 10);
		createLabelTextfield("Profesion :", 20);
		
		createButtons("Cancelar", "Aceptar");
		
	}

	private void createLabelTextfield(String label, int capacity) {
		Box box = Box.createHorizontalBox();
		
		box.add(Box.createHorizontalStrut(30));
		box.add(new JLabel(label));
		box.add(Box.createHorizontalStrut(10));
		box.add(wrapTextfield(new JTextField(capacity)));
		box.add(Box.createHorizontalStrut(10));		
		
		this.add(box);
	}

	private Component wrapTextfield(JTextField textField) {
		JPanel aux = new JPanel();
		aux.add(textField);
		return aux;
	}

	private void createButtons(String button1, String button2) {
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		box.add(new JButton(button1));
		box.add(Box.createHorizontalStrut(10));
		box.add(new JButton(button2));
		box.add(Box.createHorizontalStrut(10));		
		
		this.add(box);
	}
}