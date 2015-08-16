package pur.ultimate.exception;

public class DFException extends Exception {

	/**
	 * Dynamic form base exception
	 */
	private static final long serialVersionUID = 2900112715168392159L;

	public DFException(String msg) {
		super(msg);
	}

	public DFException() {
		super();
	}

	public DFException(String message, Throwable cause) {
		super(message, cause);
	}

	public DFException(Throwable cause) {
		super(cause);
	}
}
