package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AltaPanel extends JPanel{

	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JButton botonEnviar, botonSalir;
	/**
	 * 
	 */
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}
	private static final long serialVersionUID = 1L;
	public AltaPanel(){
		{
			
			botonEnviar= new JButton("Enviar");
			botonSalir= new JButton("Salir");
			this.add(new JLabel("Documento : "));
			this.add(txtDocumento=new JTextField(15));
			this.add(new JLabel("Nombre : "));
			this.add(txtNombre=new JTextField(15));
			this.add(new JLabel("Apellido : "));
			this.add(txtApellido=new JTextField(15));
			this.add(new JLabel("Email : "));
			this.add(txtEmail=new JTextField(15));

			this.add(botonEnviar);
			this.add(botonSalir);

			this.setSize(500,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	
	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
	}
	public JButton getButtonSalir(){
		return botonSalir;
	}
}
	
	

