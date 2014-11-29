package org.javasnow.validator.logic;

import java.util.Map;

import org.javasnow.validator.vo.ValidatorLogicResult;

/**
 * 逻辑组校验接口
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:08:29 PM
 * @Version 1.0.0
 */
public interface ILogicGroup {

	/**
	 * 逻辑校验方法
	 * 
	 * @param params
	 * @return
	 */
	public ValidatorLogicResult executeLogic(Map<String, ?> params);

}
