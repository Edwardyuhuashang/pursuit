package pur.ultimate.exception;

public class NotExitException extends DFException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1491822882050961677L;

	public NotExitException(String msg) {
		super(msg);
	}

	public NotExitException() {
		super();
	}

	public NotExitException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotExitException(Throwable cause) {
		super(cause);
	}
}
