package com.cy.shopmarket.common.exception;
/**
 *  业务层异常类
 */
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = -7118187898977415117L;
	
	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
