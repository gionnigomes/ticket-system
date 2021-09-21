package br.com.ticket.service.exception;

public class EmployeeIDNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeIDNotFound(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmployeeIDNotFound(String message) {
		super(message);
		
	}

	
}
