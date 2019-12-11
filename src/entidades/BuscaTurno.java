package entidades;

public class BuscaTurno {

	private String documentomedico;
	private String fecha;
	
	public BuscaTurno(String documentomedico, String fecha) {
		setDocumentomedico(documentomedico);
		setFecha(fecha);
	}
	
	public String getDocumentomedico() {
		return documentomedico;
	}
	public void setDocumentomedico(String documentomedico) {
		this.documentomedico = documentomedico;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
