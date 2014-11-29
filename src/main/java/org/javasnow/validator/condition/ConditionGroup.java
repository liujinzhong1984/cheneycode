package org.javasnow.validator.condition;

import java.util.Map;

import org.javasnow.validator.vo.ValidatorResult;

/**
 * 条件逻辑组校验接口
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 3:52:18 PM
 * @Version 1.0.0
 */
public interface ConditionGroup {

	/**
	 * 逻辑校验方法
	 * 
	 * @param params
	 * @return
	 */
	public ValidatorResult executeCondition(Map<String, ?> params);

}
