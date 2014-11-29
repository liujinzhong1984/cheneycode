package org.javasnow.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验目标Vo注解 <br>
 * note: 在Vo上标注此注解，表明对象适用校验
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:52:51 PM
 * @Version 1.0.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetVo {

}
