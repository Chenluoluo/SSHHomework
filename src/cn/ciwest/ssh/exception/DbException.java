package cn.ciwest.ssh.exception;

public class DbException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public DbException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
