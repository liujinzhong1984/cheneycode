package org.javasnow.validator.logic;

import java.util.List;
import java.util.Map;

import org.javasnow.validator.vo.ValidatorLogicResult;

/**
 * 逻辑组校验OR类型的集成适配器
 * 
 * @author wangxinchun1988@163.com
 * @date 2013-12-1下午1:05:36
 */
public class OrLogicGroup extends AbsLogicGroupAdapter {

	public OrLogicGroup(List<ILogicGroup> list) {
		this.list = list;
	}

	@Override
	public ValidatorLogicResult executeLogic(Map<String, ?> params) {
		if (list == null || list.size() <= 0) {
			return ValidatorLogicResult.SUCCESS;
		} else {
			StringBuilder failBuilder = new StringBuilder();
			for (ILogicGroup item : list) {
				ValidatorLogicResult result = item.executeLogic(params);
				// 如果验证通过
				if (result.isSuccess()) {
					return result;
				} else {
					failBuilder.append(result.getMessage() + (item.equals(list.get(list.size() - 1)) ? "" : ",或者"));
				}
			}
			ValidatorLogicResult failResult = ValidatorLogicResult.errorInstance(failBuilder.toString());
			return failResult;
		}
	}
}
