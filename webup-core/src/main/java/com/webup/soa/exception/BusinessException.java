package com.webup.soa.exception;


/*******************************************************************************
 * @author cgb
 * 
 */
public class BusinessException extends RuntimeException {


	private static final long serialVersionUID = -418389432305176131L;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		//super(message);
		super(message, null, false, false);
	}

	public BusinessException(String message, Throwable e) {
		//super(message, e);
		super(message, e, false, false);
	}
	
	public BusinessException(String message, Throwable e,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, e, enableSuppression, writableStackTrace);
	}

	public BusinessException(Throwable t) {
		super(t);
	}

}
