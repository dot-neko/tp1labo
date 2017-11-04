package produccion;
/*responsabilidad de la navegacion entre bo y panel*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.AltaPanel;
import ui.MainFrame;

//
public class Handler{
	 public Handler(){
		 setFrame(new MainFrame()); 
	 }
	//Declaro paneles
	private MainFrame frame;
	private JPanel panelactivo;
	private ActionListener altapaciente;
	public BO bo = new BO();

	public JPanel getPanelActivo(){
		return panelactivo;
	}
	public void setPanelAlta(AltaPanel panelalta){
		this.panelactivo=panelalta;
	}
	public void crearPanelAlta(){
		AltaPanel panelalta = new AltaPanel();
		setPanelAlta(panelalta);
		getFrame().add(getPanelActivo());
		
		MainFrame main = new MainFrame();
	}

	
	public void enviarPacienteNuevo(){        
		altapaciente = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  bo.llamarDAO();
              }
        };                
        ((AltaPanel) getPanelActivo()).getButton().addActionListener(altapaciente);   
    }
	public MainFrame getFrame() {
		return frame;
	}
	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
}


