package org.javasnow.validator.exception;

/**
 * 校验器规则配置错误
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 3:55:34 PM
 * @Version 1.0.0
 */
public class ValidatorConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6549086267781369902L;

	public ValidatorConfigException() {
	}

	public ValidatorConfigException(String message) {
		super(message);
	}
}
