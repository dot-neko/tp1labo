package produccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.AltaPanel;

//
public class Handler{
	//Declaro paneles

	private AltaPanel panelalta;
	private ActionListener actionListener;
	public BO bo =new BO();

	public JPanel getPanelAlta(){
		return panelalta;
	}
	public void setPanelAlta(AltaPanel panelalta){
		this.panelalta=panelalta;
	}
	

	
	public void enviarPacienteNuevo(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  bo.llamarDAO();
              }
        };                
        panelalta.getButton().addActionListener(actionListener);   
    }
}


