package ui;

import java.util.*;
import entidades.*;

import javax.swing.table.AbstractTableModel;

public class MedicoTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Medico> medico_list;
	private static final int DNI=0;				//static garantiza que el garbagecollector no toque la variable- final no cambiar el valor
	private static final int CONSULTORIO=1;			//con este alias evito forzar el orden de los elementos en la tabla.
	private static final int NOMBRE=2;
	private static final int APELLIDO=3;
	private static final int ESPECIALIDAD=4;
	private String TITLES[]={"DNI","CONSULTORIO","NOMBRE","APELLIDO","ESPECIALIDAD"}; //TODO: Ver de cambiar a enum?
	
	public MedicoTableModel(List<Medico> listadoMedicos) {
		
		medico_list = listadoMedicos;
	}

	public Object getValueAt(int row, int col){
		Medico medico= medico_list.get(row);
		switch(col){
			case DNI: return medico.getDocumento();
			case CONSULTORIO: return medico.getConsultorio();
			case NOMBRE: return medico.getNombre();
			case APELLIDO: return medico.getApellido();
			case ESPECIALIDAD: return medico.getEspecialidad();
		
		}
		return null;
	}
	
	public String getColumnName(int col){		//Header de la columna
		return TITLES [col];
	}
	
	public int getColumnCount(){
		return TITLES.length;
	}
	
	public int getRowCount(){
		if (medico_list != null){
			return medico_list.size();
		}else{
			return 0;
		}
	}
}
