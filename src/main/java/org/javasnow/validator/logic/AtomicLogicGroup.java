package org.javasnow.validator.logic;

import java.util.Map;

import org.javasnow.validator.exception.ValidatorConfigException;
import org.javasnow.validator.vo.ValidatorLogicResult;
import org.javasnow.validator.vo.ValidatorLogicRule;
import org.javasnow.validator.vo.ValidatorResult;

/**
 * 逻辑原子校验组 一个原子校验组对应一个逻辑校验规则
 * 
 * @author wangxinchun1988@163.com
 * @date 2013-12-1下午1:04:48
 */
public class AtomicLogicGroup implements ILogicGroup {
	private ValidatorLogicRule logic;

	public AtomicLogicGroup(final ValidatorLogicRule logic) {
		this.logic = logic;
	}

	@Override
	public ValidatorLogicResult executeLogic(Map<String, ?> params) {
		if (logic == null) {
			throw new ValidatorConfigException();
		}

		ValidatorLogicResult logicResult = null;
		ValidatorResult result = logic.getConclusionGroup().executeCondition(params);
		// 结论逻辑成功，那么设置成功的下一步
		if (result.isSuccess()) {
			logicResult = ValidatorLogicResult.successInstance();
			logicResult.setSuccessNextStep(logic.getSuccessNextStep());
		} else {// 如果失败，那么继续失败的下一步，并且设置失败原因
			logicResult = ValidatorLogicResult.errorInstance(logic.getTip());
			logicResult.setFailNextStep(logic.getFailNextStep());
			logicResult.setConditionFailNextStep(logic.getConditionFailNextStep());
			if (logic.getTip() == null || logic.getTip().isEmpty()) {
				logicResult.setMessage(result.getMessage());
			}
		}
		return logicResult;
	}

	@Override
	public String toString() {
		return "AtomicLogicGroup [logic=" + logic + "]";
	}

}
