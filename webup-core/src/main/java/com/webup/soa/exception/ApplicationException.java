package com.webup.soa.exception;


/*******************************************************************************
 * @author cgb
 * 
 */
public class ApplicationException extends RuntimeException {



	/**
	 * 
	 */
	private static final long serialVersionUID = -418389432305176131L;

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		//super(message);
		super(message, null, false, false);
	}

	public ApplicationException(String message, Throwable e) {
		//super(message, e);
		super(message, null, false, false);
	}

	public ApplicationException(Throwable e) {
		//super(e);
		super(null, e, false, false);
	}

}
