package excepciones;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String TITULO = "ERROR";
	public final static String MENSAJE="MENSAJE";
	public final static String GENERICO = "Error";
	
	public String tipo, msj, err;
	public BusinessException(String tipo, String msj, String err){
		this.tipo=tipo;
		this.msj=msj;
		this.err=err;
	}
}
