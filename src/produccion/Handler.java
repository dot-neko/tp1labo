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
	public BO bo;
	
	public MainFrame getFrame() {
		return frame;
	}
	public void setFrame(MainFrame mainFrame) {
		this.frame = mainFrame;
	}
	
	 public Handler(){
	 }
	//Declaro paneles
	public void crearMainFrame(){
		setFrame( new MainFrame());
	}
	public JPanel getPanelActivo(){
		return panelactivo;
	}
	public void setPanelAlta(AltaPanel panelalta){
		this.panelactivo=panelalta;
	}
	public void crearPanelAlta(){
		AltaPanel panelalta = new AltaPanel();
		((RootPaneContainer) getFrame()).getContentPane().removeAll();
		((RootPaneContainer) getFrame()).setContentPane(panelalta);
	}

	
	public void enviarPacienteNuevo(){        
		altapaciente = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  bo.llamarDAO();
              }
        };                
        ((AltaPanel) getPanelActivo()).getButton().addActionListener(altapaciente);   
    }
	
}


