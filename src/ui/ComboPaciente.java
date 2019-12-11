package ui;

import entidades.Paciente;

public class ComboPaciente {
	private Paciente paciente;

    public ComboPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
    	
        return paciente.getApellido() + ", " + paciente.getNombre();
    }
}
