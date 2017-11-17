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

public class ModificacionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public JTextField getTxtDocumentoInput() {
		return txtDocumentoInput;
	}

	public JTextField getTxtNombreInput() {
		return txtNombreInput;
	}

	public JTextField getTxtApellidoInput() {
		return txtApellidoInput;
	}

	public JTextField getTxtEmailInput() {
		return txtEmailInput;
	}

	private JTextField txtNombreInput;
	private JTextField txtApellidoInput;
	private JTextField txtEmailInput;
	private JTextField txtDocumento;

	private JTextField txtDocumentoInput;
	private JButton botonBuscar;
	
	private JButton botonActualizar;


	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public ModificacionPanel(BO miBO) {
		botonBuscar = new JButton("Buscar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento = new JTextField(15));
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Voy a buscar paciente
				
				try {
					int documento=Integer.valueOf(getTxtDocumento().getText());
					Paciente p= new Paciente(documento);
					p=miBO.validarPacienteporBusqueda(p);
					
					//Pego los valores
					getTxtNombreInput().setText(p.getNombre());
					getTxtApellidoInput().setText(p.getApellido());
					getTxtDocumentoInput().setText(String.valueOf(p.getDocumento()));
					getTxtEmailInput().setText(p.getEmail());
					
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, BusinessException.MENSAJE, BusinessException.TITULO, 1);
				} catch(NumberFormatException  er){
					JOptionPane.showMessageDialog(null, BusinessException.ERRNUMERO, BusinessException.TITULO, 1);
					er.printStackTrace();
				} catch(NullPointerException er1){
					JOptionPane.showMessageDialog(null, BusinessException.NOENCONTRADO, BusinessException.TITULO, 1);
					er1.printStackTrace();
				} 

			}
		});
		this.add(botonBuscar);
		
		//devolucion;
		botonActualizar = new JButton("Actualizar");
		this.add(new JLabel("Nombre :"));
		this.add(txtNombreInput= new JTextField(20));
		this.add(new JLabel("Apellido :"));
		this.add(txtApellidoInput= new JTextField(20));
		this.add(new JLabel("Documento :"));
		this.add(txtDocumentoInput= new JTextField(15));
		this.add(new JLabel("Email :"));
		this.add(txtEmailInput= new JTextField(15));
		
		botonActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int documento= Integer.valueOf(getTxtDocumentoInput().getText()) ;
        		String nombre= getTxtNombreInput().getText();
        		String apellido= getTxtApellidoInput().getText();
        		String email = getTxtEmailInput().getText();
        		Paciente p= new Paciente(documento,nombre,apellido,email);
        		try {
					miBO.updatePaciente(p);
				} catch (BusinessException e1) {
					JOptionPane.showMessageDialog(null, BusinessException.MENSAJE, BusinessException.TITULO, 1);
					e1.printStackTrace();
				} catch(NumberFormatException  er){
					JOptionPane.showMessageDialog(null, BusinessException.ERRNUMERO, BusinessException.TITULO, 1);
					er.printStackTrace();
				}
        		getTxtNombreInput().setText(null);
				getTxtApellidoInput().setText(null);
				getTxtDocumentoInput().setText(null);
				getTxtEmailInput().setText(null);
			}
		});
		
		this.add(botonActualizar);
		this.setSize(500, 300);
		this.setLocation(20, 100);


	}
}
