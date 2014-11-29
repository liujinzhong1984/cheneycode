package org.javasnow.validator.validators;

import java.util.Map;

import cn.javaframe.validator.bean.ValidateResult;
import cn.javaframe.validator.bean.RuleVO;

/**
 * 数字格式校验
 * @author xinchun.wang
 *
 */
public class NumberFormatValidator extends AbstractValidator {

	@Override
	public ValidateResult validate(RuleVO validator, Map<String, ?> params) {
			String value = params.get(validator.getProperty()).toString();
			try{
				String type = validator.getRule();
				if(type.equals("int")){
					Integer.parseInt(value);
				}else if(type.equals("long")){
					Long.parseLong(value);
				} else{
					Double.parseDouble(value);
				}
				return ValidateResult.SUCCESS;
			}catch(Exception e) {
				logWarn(e, validator.getProperty(),params.get(validator.getProperty()),validator.getRule(),this.getClass().getName());
				return ValidateResult.errorInstance(validator.getTip());
			}
	}
}
