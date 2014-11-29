package org.javasnow.validator.vo;

/**
 * 校验结果,单步校验
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 11:53:42 AM
 * @Version 1.0.0
 */
public class ValidatorResult {
	/** 验证结果 */
	private boolean success;

	/**提示信息 <br>
	 * 如果失败会有提醒信息，成功无提醒 */
	private String message;

	public static final ValidatorResult SUCCESS = new ValidatorResult(true, null);
	public static final ValidatorResult FAIL = new ValidatorResult(false, null);

	public static final ValidatorResult errorInstance(String message) {
		return new ValidatorResult(false, message);
	}

	public ValidatorResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
