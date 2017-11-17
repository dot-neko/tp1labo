package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import excepciones.BusinessException;
import produccion.BO;

public class AltaPanel extends JPanel{

	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JButton botonEnviar;
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
	public AltaPanel(BO miBO){
		{
			
			botonEnviar= new JButton("Enviar");

			this.add(new JLabel("Documento : "));
			this.add(txtDocumento=new JTextField(15));
			this.add(new JLabel("Nombre : "));
			this.add(txtNombre=new JTextField(15));
			this.add(new JLabel("Apellido : "));
			this.add(txtApellido=new JTextField(15));
			this.add(new JLabel("Email : "));
			this.add(txtEmail=new JTextField(15));
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	          		
	        		//Envia Paciente a BO
	            	try {
	            		int documento= Integer.valueOf(getTxtDocumento().getText()) ;
		        		String nombre= getTxtNombre().getText();
		        		String apellido= getTxtApellido().getText();
		        		String email = getTxtEmail().getText();
		        		Paciente p= new Paciente(documento,nombre,apellido,email);
						miBO.ValidarPacienteNuevo(p);
					} catch (BusinessException e) {
						JOptionPane.showMessageDialog(null, BusinessException.MENSAJE, BusinessException.TITULO, 1);
						e.printStackTrace();
					} catch(NumberFormatException er){
						JOptionPane.showMessageDialog(null, BusinessException.ERRNUMERO, BusinessException.TITULO, 1);
						er.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	              }
	        });
			this.add(botonEnviar);


			this.setSize(500,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	
	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
	}

}
	
	

