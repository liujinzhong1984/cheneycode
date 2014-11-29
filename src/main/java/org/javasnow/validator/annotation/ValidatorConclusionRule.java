package org.javasnow.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.javasnow.validator.AbsValidatorEnum.RuleType;
import org.javasnow.validator.AbsValidatorEnum.TipType;

/**
 * 推导结果项注解
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:56:52 PM
 * @Version 1.0.0
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorConclusionRule {

	/** 规则项的位唯一id属性*/
	public String id();
	
	/**
	 * 验证规则名字
	 */
	public RuleType type() default RuleType.LOCAL_TYPE;

	/**
	 * 验证规则值
	 */
	public String value() default "";

	/**
	 * 此验证失败后的提示信息，如果没有配置那么从ConclusionItem 取tip信息
	 */
	public String tip() default "";
	
	/**
	 * 提示类型
	 * @return
	 */
	public TipType tipType() default TipType.COMBINE;
	
	/**
	 * 扩展本地校验规则
	 * @return
	 */
	public String local() default "";
	
}
