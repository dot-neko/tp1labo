package produccion;
/*responsabilidad de la navegacion entre bo y panel*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import ui.AltaPanel;
import ui.MainFrame;

//
public class Handler{
	private MainFrame frame;
	private JPanel panelactivo;
	private ActionListener altapaciente;
	BO miBO;
	MainFrame miFrame;

	
	 public Handler(){
	 }
	//Declaro paneles

	public JPanel getPanelActivo(){
		return panelactivo;
	}
	public void setPanelAlta(AltaPanel panelalta){
		this.panelactivo=panelalta;
	}
	public void crearPanelAlta(){
		AltaPanel panelalta = new AltaPanel();
		miFrame.getContentPane().removeAll();
		miFrame.setContentPane(panelalta);;
	}

	
	public void enviarPacienteNuevo(){        
		altapaciente = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
            	  miBO.llamarDAO();
              }
        };                
        ((AltaPanel) getPanelActivo()).getButton().addActionListener(altapaciente);   
    }


	public void addMainFrame(MainFrame miFrame) {
		System.out.println("Agregando Frame a Handler");
		this.miFrame = miFrame;
		
	}
	public void addBO(BO miBO) {
		System.out.println("Agregando BO a Handler");
		this.miBO = miBO;
	}
	
}


