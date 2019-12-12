	package ui;

import entidades.Medico;

public class MedicoItem {
	private Medico medico;

    public MedicoItem(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    @Override
    public String toString() {
    	
        return medico.getApellido() + ", " + medico.getNombre();
    }
}
