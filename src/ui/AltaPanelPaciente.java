package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import produccion.Handler;

public class AltaPanelPaciente extends JPanel{
//usar flowlayout--boxlayout
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JButton botonEnviar;
	private Handler handler;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public AltaPanelPaciente(Handler handler){
		{
			this.handler=handler;
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			this.add(new JLabel("Documento : "));
			this.add(txtDocumento=new JTextField(15));
			txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
			
			this.add(new JLabel("Nombre : "));
			this.add(txtNombre=new JTextField(20));
			txtNombre.setMaximumSize(txtNombre.getPreferredSize());
			
			this.add(new JLabel("Apellido : "));
			this.add(txtApellido=new JTextField(20));
			txtApellido.setMaximumSize(txtApellido.getPreferredSize());
			
			this.add(new JLabel("Email : "));
			this.add(txtEmail=new JTextField(30));
			txtEmail.setMaximumSize(txtEmail.getPreferredSize());
			
			botonEnviar= new JButton("Enviar");
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	            	  ///handler.altaPaciente(panelToObject());
	            	  
	            	  
	            	  String documento= getTxtDocumento().getText();
            		  String nombre= getTxtNombre().getText();
            		  String apellido= getTxtApellido().getText();
	            	  String email = getTxtEmail().getText();
	            	  Paciente p= new Paciente(documento,nombre,apellido,email);
	            	  //Envia Paciente a BO
	            	  getHandler().IngresarPacienteCompleto(p);
	              }
	        });
			this.add(botonEnviar);

			//Configuracion de panel
			this.setSize(300,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	
	//getters botones
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
	
	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
	}

	//getters y setters
	public Handler getHandler() {
		return handler;
	}

}
	
	

