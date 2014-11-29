package org.javasnow.validator.condition;

import java.util.Map;

import org.javasnow.validator.AbsValidatorEnum.RuleType;
import org.javasnow.validator.IValidator;
import org.javasnow.validator.condition.ConditionGroup;
import org.javasnow.validator.exception.ValidatorConfigException;
import org.javasnow.validator.vo.ValidatorResult;
import org.javasnow.validator.vo.ValidatorRule;

/**
 * 原子校验组
 * 一个原子校验组拥有一个校验器
 * @author wangxinchun1988@163.com
 * @date 2013-12-1下午1:04:48
 */
public class AtomitConditionGroup implements ConditionGroup {
	private ValidatorRule ruleVo;
	public AtomitConditionGroup(final ValidatorRule ruleVo) {
		this.ruleVo = ruleVo;
	}
	
	@Override
	public ValidatorResult executeCondition(Map<String, ?> params) {
		if(ruleVo == null){
			throw new ValidatorConfigException();
		}
		IValidator validator = null;
		/* 找到验证器*/
		if(RuleType.LOCAL_TYPE == ruleVo.getRuleType()){
			String localRule = ruleVo.getLocal();
			validator = ValidatorFactory.getLocalValidator(localRule);
		} else {
			validator = ValidatorFactory.getCommonValidator(ruleVo.getRuleType());
		}
		if(validator == null){
			throw new IllegalStateException(ruleVo + "没有注册有效的验证器");
		}
		
		ValidatorResult result = validator.validate(ruleVo, params);
		return result;
	}

	@Override
	public String toString() {
		return "AtomitConditionGroup [ruleVo=" + ruleVo + "]";
	}

}
