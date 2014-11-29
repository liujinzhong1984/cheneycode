package org.javasnow.validator.logic;

import java.util.Map;

import org.javasnow.validator.AbsValidatorEnum.NextStepType;
import org.javasnow.validator.exception.ValidatorConfigException;
import org.javasnow.validator.vo.ValidatorLogicResult;
import org.javasnow.validator.vo.ValidatorLogicRule;
import org.javasnow.validator.vo.ValidatorResult;

/**
 * 推导原子校验组 一个推导原子校验组拥有一个校验器
 * 
 * @author wangxinchun1988@163.com
 * @date 2013-12-1下午1:04:48
 */
public class DeduceAtomicLogicGroup implements ILogicGroup {
	private ValidatorLogicRule logic;

	public DeduceAtomicLogicGroup(final ValidatorLogicRule logic) {
		this.logic = logic;
	}

	@Override
	public ValidatorLogicResult executeLogic(Map<String, ?> params) {
		if (logic == null) {
			throw new ValidatorConfigException();
		}
		ValidatorLogicResult logicResult = null;
		ValidatorResult conditionResult = logic.getConditionGroup().executeCondition(params);
		// 条件验证成功，那么验证结论逻辑
		if (conditionResult.isSuccess()) {
			ValidatorResult conclusionResult = logic.getConclusionGroup().executeCondition(params);
			// 结论逻辑成功，那么设置成功的下一步
			if (conclusionResult.isSuccess()) {
				logicResult = ValidatorLogicResult.successInstance();
				logicResult.setSuccessNextStep(logic.getSuccessNextStep());
			} else {// 如果失败，那么继续失败的下一步，并且设置失败原因
				logicResult = ValidatorLogicResult.errorInstance(logic.getTip()); // TODO
				logicResult.setFailNextStep(logic.getFailNextStep());
				if (logic.getTip() == null || logic.getTip().isEmpty()) {
					logicResult.setMessage(conclusionResult.getMessage());
				}
			}
		} else { // 如果条件失败，那么判断条件失败的下一步
			if (logic.getConditionFailNextStep() == NextStepType.GONEXT) {
				logicResult = ValidatorLogicResult.successInstance();
				logicResult.setFailNextStep(NextStepType.GONEXT);
			} else if (logic.getConditionFailNextStep() == NextStepType.RETURNFAIL) {
				// 如果条件失败，那么返回此逻辑验证的失败message
				logicResult = ValidatorLogicResult.errorInstance(logic.getTip());
				logicResult.setFailNextStep(NextStepType.RETURNFAIL);
			}
		}
		return logicResult;
	}

}
