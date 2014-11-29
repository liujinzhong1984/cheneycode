package org.javasnow.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.javasnow.validator.AbsValidatorEnum.LogicAssembleType;
import org.javasnow.validator.AbsValidatorEnum.TargetType;

/**
 * 验证规则集 配置在Vo的成员上，代表一组校验规则集
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:53:23 PM
 * @Version 1.0.0
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorRules {

	/** 字段的属性 是否是复杂属性 */
	TargetType targetType() default TargetType.SIMPLE;

	/**
	 * 结论规则集合
	 */
	ValidatorConclusionRule[] conclusionList() default {};

	/**
	 * 条件规则集合
	 */
	ValidatorConditionRule[] conditionList() default {};

	/**
	 * 逻辑验证规则集合
	 */
	ValidatorLogicRule[] logicList() default {};

	/** 成员字段名称 */
	String text() default "";

	/** 校验顺序，默认同一order值，按照在VO中出现的先后顺序校验 */
	int order() default Integer.MIN_VALUE;

	/** LogicRule的组合模式，默认为AND组合 */
	LogicAssembleType assembleType() default LogicAssembleType.AND;

}
