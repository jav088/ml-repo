package ar.com.ml.challenge.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 8783068439051775481L;
	private Integer codError;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Integer codError) {
		super(message);
		this.codError = codError;
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public Integer getCodError() {
		return codError;
	}

	public void setCodError(Integer codError) {
		this.codError = codError;
	}
}