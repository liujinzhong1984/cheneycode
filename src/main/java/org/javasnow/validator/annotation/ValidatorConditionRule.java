package org.javasnow.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.javasnow.validator.AbsValidatorEnum.RuleType;

/**
 * 条件项注解 tip: 条件项的注解，不需要包括 字段验证的失败信息。
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:56:27 PM
 * @Version 1.0.0
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorConditionRule {

	public String id();

	/**
	 * 验证规则名字
	 */
	public RuleType type() default RuleType.LOCAL_TYPE;

	/**
	 * 验证规则值
	 */
	public String value() default "";

	/** 依赖参照熟悉 */
	public String dependProperty() default "";

	/**
	 * 扩展本地校验规则
	 * 
	 * @return
	 */
	public String local() default "";

}
