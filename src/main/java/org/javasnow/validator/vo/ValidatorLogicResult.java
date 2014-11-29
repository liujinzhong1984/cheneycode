package org.javasnow.validator.vo;

import org.javasnow.validator.AbsValidatorEnum.NextStepType;

/**
 * 逻辑校验结果
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 11:54:09 AM
 * @Version 1.0.0
 */
public class ValidatorLogicResult {
	/** 验证结果 */
	private boolean success;

	/** 提示信息，如果失败会有提示信息，成功提示为null或者"" */
	private String message;

	/**
	 * 逻辑校验成功后下一步执行逻辑 <br/>
	 * 1、NextStepType.goNext <br/>
	 * 默认进行下一个校验规则的验证。（如果词条为最后一个逻辑项，那么等同于NextStepType.returnSuccess）<br/>
	 * 2、NextStepType.returnSuccess <br/>
	 * 表示此验证完成之后，不再进行下一个校验规则的验证 ，直接返回校验成功
	 * */
	private NextStepType successNextStep = NextStepType.GONEXT;
	/**
	 * 逻辑校验失败后下一步执行逻辑 <br/>
	 * 1、NextStepType.returnFail <br/>
	 * 默认校验失败时，直接返回校验失败 <br/>
	 * 2、NextStepType.goNext <br/>
	 * 校验继续下一个词条的校验（如果词条为最后一个逻辑项，那么等同于NextStepType.returnSuccess）
	 * */
	private NextStepType failNextStep = NextStepType.RETURNFAIL;

	/**
	 * 如果条件校验失败，那么下一步的执行逻辑 <br>
	 * 1、NextStepType.goNext<br/>
	 * 默认条件校验失败，进入下一个逻辑词条的校验（如果词条为最后一个逻辑项，那么等同于NextStepType.returnSuccess）<br>
	 * 2、NextStepType.returnFail 不进行下一个词条的校验，直接返回校验失败 <br>
	 * 3、NextStepType.returnSuccess 不进行下一个词条的校验，直接返回校验成功
	 * */
	private NextStepType conditionFailNextStep = NextStepType.GONEXT;

	public static final ValidatorLogicResult SUCCESS = new ValidatorLogicResult(true, null);
	public static final ValidatorLogicResult FAIL = new ValidatorLogicResult(false, null);

	public static final ValidatorLogicResult errorInstance(String message) {
		return new ValidatorLogicResult(false, message);
	}

	public static final ValidatorLogicResult successInstance() {
		return new ValidatorLogicResult(true, null);
	}

	public ValidatorLogicResult(boolean success, String message) {
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

	public NextStepType getSuccessNextStep() {
		return successNextStep;
	}

	public void setSuccessNextStep(NextStepType successNextStep) {
		this.successNextStep = successNextStep;
	}

	public NextStepType getFailNextStep() {
		return failNextStep;
	}

	public void setFailNextStep(NextStepType failNextStep) {
		this.failNextStep = failNextStep;
	}

	public NextStepType getConditionFailNextStep() {
		return conditionFailNextStep;
	}

	public void setConditionFailNextStep(NextStepType conditionFailNextStep) {
		this.conditionFailNextStep = conditionFailNextStep;
	}
}
