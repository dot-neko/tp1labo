package entidades;


public class Turno {
	
	private String documentoMedico;
	private String fecha_hora;
	private String documentoPaciente;
	private String consultorio;
	private String reservado;
	
	public Turno(String documentoMedico, String turno, String consultorio, String reservado) {
		this.documentoMedico = documentoMedico;
		this.fecha_hora = turno;
		this.consultorio = consultorio;
		this.reservado = reservado;
	}
	
	public Turno(String documentoMedico, String documentoPaciente, String turno, String consultorio, String reservado) {
		this.documentoPaciente = documentoPaciente;
		this.documentoMedico = documentoMedico;
		this.fecha_hora = turno;
		this.consultorio = consultorio;
		this.reservado = reservado;
	}
	
	public Turno(String documentoMedico, String fecha) {
		this.documentoMedico = documentoMedico;
		this.fecha_hora = fecha;
	}
	
	public void setdocumentoMedico(String documentoMedico) {
		this.documentoMedico = documentoMedico;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public String getdocumentoMedico() {
		return documentoMedico;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(String turno) {
		this.fecha_hora = turno;
	}

	public String getdocumentoPaciente() {
		return documentoPaciente;
	}
	public void setdocumentoPaciente(String documentoPaciente) {
		this.documentoPaciente = documentoPaciente;
	}
	public String getConsultorio() {
		return consultorio;
	}
	public String getReservado() {
		return reservado;
	}
	public void setReservado(String reservado) {
		this.reservado = reservado;
	}
	
	
}
