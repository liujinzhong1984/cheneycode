package org.javasnow.validator.logic;

import java.util.List;
import java.util.Map;

import org.javasnow.validator.AbsValidatorEnum.NextStepType;
import org.javasnow.validator.vo.ValidatorLogicResult;

/**
 * 逻辑组校验AND类型的集成适配器
 * @author wangxinchun1988@163.com
 * @date 2013-12-1下午1:06:55
 */
public  class AndLogicGroup extends AbsLogicGroupAdapter {

	public AndLogicGroup(List<ILogicGroup> list) {
		this.list = list;
	}
	@Override
	public ValidatorLogicResult executeLogic(Map<String, ?> params) {
		if(list == null || list.size() <= 0){
			return ValidatorLogicResult.SUCCESS;
		}else {
			for(ILogicGroup item : list){
				ValidatorLogicResult result = item.executeLogic(params);
				if(!result.isSuccess()){ 
					//AND类型的逻辑的组合，如果第一个失败，并且 result.getConditionFailNextStep() == NextStepType.returnFail 直接返回
					if(result.getFailNextStep() == NextStepType.RETURNFAIL){
						return result;
					} else if (result.getFailNextStep() == NextStepType.GONEXT){ //如果goNext 那么判断下一个and逻辑组
						continue;
					}
				}else {
					//如果当前研究组合成功，那么
					if(result.getSuccessNextStep() == NextStepType.RETURNSUCCESS){
						return result;
					}
				}
			}
			return ValidatorLogicResult.SUCCESS;
		}
	}
	
	@Override
	public String toString() {
		return "AndLogicGroupAdapter [list=" + list + "]";
	}
	
	
}
