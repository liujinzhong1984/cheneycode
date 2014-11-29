package org.javasnow.validator.exception;

/**
 * 逻辑规则配置错误
 * @author cheney
 * @date Nov 28, 2014
 * @time 3:54:52 PM
 * @Version 1.0.0
 */
public class LogicConfigException extends RuntimeException {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -3027867370457733344L;

	public LogicConfigException() {
	}

	public LogicConfigException(String message) {
		super(message);
	}
}
