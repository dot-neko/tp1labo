package entidades;


public class Turno {
	
	private Paciente paciente;
	private Medico medico;
	private String fechaHora;
	private String reservado;
	
	public Turno(String fechaHora, String reservado, Medico medico) {
		this.fechaHora = fechaHora;
		this.reservado = reservado;
		this.medico=medico;
	}
	
	public Turno(String fechaHora, String reservado, Medico medico, Paciente paciente) {
		this.fechaHora = fechaHora;
		this.reservado = reservado;
		this.medico=medico;
		this.paciente=paciente;
	}
	
	public Turno(Medico medico, String fecha) {
		this.fechaHora = fecha;
		this.medico=medico;
	}

	public String getdocumentoMedico() {
		return medico.getDocumento();
	}

	public String getfechaHora() {
		return fechaHora;
	}
	public void setFecha_hora(String turno) {
		this.fechaHora = turno;
	}

	public String getdocumentoPaciente() {
		return paciente.getDocumento();
	}
	public String getConsultorio() {
		return medico.getConsultorio();
	}
	public String getReservado() {
		return reservado;
	}
}
