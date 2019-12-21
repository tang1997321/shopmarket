package com.cy.shopmarket.common.util;
/**
 *	判定类
 */
public class Assert {
	public Assert() {}
	
	public static void isValid(boolean valid,String message) {
		if(!valid)
			throw new IllegalArgumentException(message);
	}
	public static void isNull(Object object,String message) {
		if(object==null)
			throw new IllegalArgumentException(message);
	}
	public static void isEmpty(String string,String message) {
		if(string==null||"".equals(string.trim()))
			throw new IllegalArgumentException(message);
	}
}
