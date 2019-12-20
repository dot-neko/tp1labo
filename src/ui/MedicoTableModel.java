package ui;

import java.util.*;
import entidades.*;

import javax.swing.table.AbstractTableModel;

public class MedicoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Medico> medicoList;
	private static final int MEDICODNI=0;				//static garantiza que el garbagecollector no toque la variable- final no cambiar el valor
	private static final int MEDICOCONSULTORIO=1;			//con este alias evito forzar el orden de los elementos en la tabla.
	private static final int MEDICONOMBRE=2;
	private static final int MEDICOAPELLIDO=3;
	private static final int MEDICOESPECIALIDAD=4;
	private String TITLES[]={"DNI","CONSULTORIO","NOMBRE","APELLIDO","ESPECIALIDAD"}; //TODO: Ver de cambiar a enum?
	
	public MedicoTableModel(List<Medico> listadoMedicos) {
		
		medicoList = listadoMedicos;
	}
	@Override
	public Object getValueAt(int row, int col){
		Medico medico= medicoList.get(row);
		switch(col){
			case MEDICODNI: return medico.getDocumento();
			case MEDICOCONSULTORIO: return medico.getConsultorio();
			case MEDICONOMBRE: return medico.getNombre();
			case MEDICOAPELLIDO: return medico.getApellido();
			case MEDICOESPECIALIDAD: return medico.getEspecialidad();
		
		}
		return null;
	}
	@Override
	public String getColumnName(int col){		//Header de la columna
		return TITLES [col];
	}
	@Override
	public int getColumnCount(){
		return TITLES.length;
	}
	@Override
	public int getRowCount(){
		if (medicoList != null){
			return medicoList.size();
		}else{
			return 0;
		}
	}
	/*@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
	    return true;
	}*/
	public void medicoList(List<Medico> medicoList) {
		this.medicoList = medicoList;
	}
	

	
}
