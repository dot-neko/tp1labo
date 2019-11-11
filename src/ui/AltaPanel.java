package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import excepciones.BusinessException;
import produccion.Handler;

public class AltaPanel extends JPanel{
//usar flowlayout--boxlayout
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JButton botonEnviar;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public AltaPanel(Handler handler){
		{
			
			this.add(new JLabel("Documento : "));
			this.add(txtDocumento=new JTextField(15));
			
			this.add(new JLabel("Nombre : "));
			this.add(txtNombre=new JTextField(15));
			
			this.add(new JLabel("Apellido : "));
			this.add(txtApellido=new JTextField(15));
			
			this.add(new JLabel("Email : "));
			this.add(txtEmail=new JTextField(15));
			
			botonEnviar= new JButton("Enviar");
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	            	  String documento= getTxtDocumento().getText();
            		  String nombre= getTxtNombre().getText();
            		  String apellido= getTxtApellido().getText();
	            	  String email = getTxtEmail().getText();
	            	  Paciente p= new Paciente(documento,nombre,apellido,email);
	        		//Envia Paciente a BO
	            	  try {
	            		  handler.getBO().ValidarPacienteNuevo(p);// al handler
	            	  } catch (BusinessException be) {
	            		  handler.HandleBusinessException(be);
	            	  } catch (Exception e) {
	            		  handler.GeneralException(e);
	            	  }
	              }
	        });
			this.add(botonEnviar);


			this.setSize(500,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	
	//getters
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

}
	
	

