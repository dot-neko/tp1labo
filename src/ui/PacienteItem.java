package ui;

import entidades.Paciente;

public class PacienteItem {
	private Paciente paciente;

    public PacienteItem(Paciente paciente) {
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
