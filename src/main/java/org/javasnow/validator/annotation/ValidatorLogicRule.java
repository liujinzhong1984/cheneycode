package org.javasnow.validator.annotation;

import org.javasnow.validator.AbsValidatorEnum.NextStepType;
import org.javasnow.validator.AbsValidatorEnum.TipType;

/**
 * 逻辑项注解
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:55:31 PM
 * @Version 1.0.0
 */
public @interface ValidatorLogicRule {

	/**
	 * 条件：逻辑条件表达式。<BR>
	 * tips：简单逻辑没有条件的，推导逻辑才有条件
	 */
	public String condition() default "";

	/**
	 * 结论：要验证的结论表达式 <br>
	 * eg:(A&&B)||C
	 * */
	public String conclusion();

	/**
	 * 逻辑验证成功的下一步执行逻辑 <br/>
	 * 1、NextStepType.GONEXT
	 * 默认进行下一个校验规则的验证。（如果词条为最后一个逻辑项，那么等同于NextStepType.RETURNSUCCESS）<br/>
	 * 2、NextStepType.RETURNSUCCESS 表示此验证完成之后，不再进行下一个校验规则的验证 ，直接返回校验成功
	 * */
	public NextStepType successNextStep() default NextStepType.GONEXT;

	/**
	 * 逻辑校验失败后下一步执行逻辑 1、NextStepType.RETURNFAIL 默认校验失败时，直接返回校验失败
	 * 2、NextStepType.GONEXT
	 * 校验继续下一个词条的校验（如果词条为最后一个逻辑项，那么等同于NextStepType.RETURNSUCCESS）
	 * */
	public NextStepType failNextStep() default NextStepType.RETURNFAIL;

	/**
	 * 条件验证失败的下一步返回类型 <br>
	 * 1、NextStepType.GONEXT
	 * 默认条件校验失败，进入下一个逻辑词条的校验（如果词条为最后一个逻辑项，那么等同于NextStepType.RETURNSUCCESS）<br>
	 * 2、NextStepType.RETURNFAIL 不进行下一个词条的校验，直接返回校验失败 <br>
	 * 3、NextStepType.RETURNSUCCESS 不进行下一个词条的校验，直接返回校验成功
	 * */
	public NextStepType conditionFailNextStep() default NextStepType.GONEXT;

	/**
	 * 验证失败后的提示信息，此信息优先级最高
	 */
	public String tip() default "";

	/**
	 * 提示类型
	 */
	public TipType tipType() default TipType.COMBINE;
}
