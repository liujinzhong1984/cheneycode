package org.javasnow.validator.vo;

import org.javasnow.validator.AbsValidatorEnum.NextStepType;
import org.javasnow.validator.condition.ConditionGroup;

/**
 * 逻辑校验规则
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 11:53:58 AM
 * @Version 1.0.0
 */
public class ValidatorLogicRule {
	private ConditionGroup conditionGroup;
	private ConditionGroup conclusionGroup;
	private String tip; // 校验失败提醒信息
	private NextStepType successNextStep;
	private NextStepType failNextStep;
	private NextStepType conditionFailNextStep;
	
	public ConditionGroup getConditionGroup() {
		return conditionGroup;
	}
	public void setConditionGroup(ConditionGroup conditionGroup) {
		this.conditionGroup = conditionGroup;
	}
	public ConditionGroup getConclusionGroup() {
		return conclusionGroup;
	}
	public void setConclusionGroup(ConditionGroup conclusionGroup) {
		this.conclusionGroup = conclusionGroup;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
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
