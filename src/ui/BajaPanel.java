/*
package ui;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import produccion.Handler;

public class BajaPanel extends JPanel {
	/**
	 * 
	 */
/*
	private static final long serialVersionUID = 1L;
	//VARIABLES LOCALES
	private String[] campolabelsStrings= {"Documento"};
	private String[] campotextoArray = new String[campolabelsStrings.length];
	Handler handlertexto = new Handler(campotextoArray);
	
	//CONSTRUCTOR
	public BajaPanel(){
		this.add(createLabelTextfield(campolabelsStrings[0], 15));
		this.add(createButtons("Enviar"));
	}
	
	private Box createButtons(String button1) {
		Box box = Box.createVerticalBox();
		JButton botonenviar = new JButton(button1);
		//TODO: Se podría agregar una lista con un "for" para no repetir codigo
		box.add(Box.createVerticalGlue());
		box.add(botonenviar);
		//Handler de botones
		//Agrego listener al boton
		botonenviar.addActionListener(handlertexto);
		return box;
	}
	private Box createLabelTextfield(String label, int capacity) {
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalStrut(30));
		box.add(new JLabel("Ingresar" + label + " : "));
		box.add(Box.createHorizontalStrut(10));
		JTextField cajatexto= new JTextField(capacity);
		box.add(wrapTextfield(cajatexto));// agrego al container "box" un jpanel con un campo de texto
		box.add(Box.createHorizontalStrut(10));
		cajatexto.addFocusListener(new FocusListener() {
			@Override
			//EVENTO LOSTFOCUS COPIA TEXTO
			public void focusLost(FocusEvent e) {
				try {
					campotextoArray[0]=cajatexto.getText();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Ingresar un valor en el cuadro");
					e1.printStackTrace();
				}
			}
			@Override
			//EVENTO GAIN FOCUS MAPEA ARRAY SELECCIONADO
			public void focusGained(FocusEvent e) {
				if(campolabelsStrings[0]==label && campotextoArray[0]==null){
						cajatexto.setText(null);
				}
			}
		});		
		return box;
	}
	private Component wrapTextfield(JTextField textField) {
		JPanel aux = new JPanel();
		aux.add(textField);
		return aux;
	}
}

*/
