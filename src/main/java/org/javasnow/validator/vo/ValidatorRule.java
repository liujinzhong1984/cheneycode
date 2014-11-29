package org.javasnow.validator.vo;

import org.javasnow.validator.AbsValidatorEnum.RuleType;

/**
 * 校验规则,单步校验
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 11:53:28 AM
 * @Version 1.0.0
 */
public class ValidatorRule {
	/** 校验规则 */
	private String rule;

	/** 待校验的字段 */
	private String property;

	/** 验证规则的类型 */
	private RuleType ruleType;

	/** 扩展本地的校验器名称 */
	private String local;

	/** 校验失败提醒信息 */
	private String tip;

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public RuleType getRuleType() {
		return ruleType;
	}

	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(100);
		buffer.append(" ValRule [rule = ").append(rule).append(",");
		buffer.append("			 property=").append(property).append(",");
		buffer.append("			 ruleType=").append(ruleType).append(",");
		buffer.append("			 local=").append(local).append(",");
		buffer.append("			 tip=").append(tip).append("]");

		return buffer.toString();
	}
}
