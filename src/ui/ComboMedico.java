	package ui;

import entidades.Medico;

public class ComboMedico {
	private Medico medico;

    public ComboMedico(Medico medico) {
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
