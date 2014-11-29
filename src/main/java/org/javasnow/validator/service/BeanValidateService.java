package org.javasnow.validator.service;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.javaframe.validator.ConvertMapAble;
import cn.javaframe.validator.EnumConstants.TargetType;
import cn.javaframe.validator.annotation.Rules;
import cn.javaframe.validator.annotation.TargetBean;
import cn.javaframe.validator.bean.ValidateResult;
import cn.javaframe.validator.util.BeanHelper;

/**
 * 对象通用验证器 <br>
 * 
 * 根据cls 检索其字段上的注解，解析注解，然后校验params的信息。
 * @author xinchun.wang
 * 
 */
public class BeanValidateService extends AbstractValidateService implements IBeanValidatorService {
	final private static ConcurrentHashMap<Class<?>,Boolean> beanAnnotationMapping = new ConcurrentHashMap<Class<?>,Boolean>();
	
	@SuppressWarnings("unchecked")
	@Override
	public ValidateResult validate(Object bean) {
		if(bean == null){
			throw new RuntimeException("bean 不能为空");
		}
		Class<?> cls = bean.getClass();
		// 这个对象必须使用 @TargetBean 注解
		if(checkTargetBean(cls)) {
			return ValidateResult.SUCCESS;
		}
		Map<Field, Rules> fieldRuleMap = getRuleMap(cls);
		for (Map.Entry<Field, Rules> item : fieldRuleMap.entrySet()) {
			Field itemField = item.getKey();
			Rules rules = item.getValue();
			if(rules == null){
				continue;
			}
			//如果当前校验规则是复杂校验规则
			if(rules.targetType() ==TargetType.complex) {
				Object obj = null;
	            try {
	            	itemField.setAccessible(true);
	            	obj = itemField.get(bean);
				} catch (Exception e) {
					throw new RuntimeException("请检测是否设置"+ itemField.getName() +" get方法", e);
				}		
	            if(obj != null){
	            	ValidateResult result = null;
	            	if(obj.getClass().isArray()) {
	            		result = doArrayValidator(obj);
	            	} else if(obj instanceof Collection){
	            		result = doCollectionValidator((Collection<?>)obj);
	            	} else{
	            		result = doValidate(obj);
	            	}
	            	if(!result.isSuccess()){
            			return result;
            		} else{
            			continue;
            		}
	            }else{
	            	continue;
	            }
			}
			Map<String,?> logicParams = null;
			if(bean instanceof Map) {
				logicParams =  (Map<String, ?>)bean;
			} else if(bean instanceof ConvertMapAble)  {
				logicParams = ((ConvertMapAble)bean).toMap();
			} else {
				logicParams = BeanHelper.bean2Map(bean);
			}
			ValidateResult result = processRules(itemField,rules,logicParams);
			if(!result.isSuccess()){
				return result;
			}
		}
		return ValidateResult.SUCCESS;
	}
	
	
	private boolean checkTargetBean(Class<?> cls){
		if(cls == null){
			return false;
		}
		Boolean result = beanAnnotationMapping.get(cls);
		if(result != null){
			return result;
		}
		if(cls.getAnnotation(TargetBean.class) == null){
			beanAnnotationMapping.put(cls, false);
			return false;
		}
		beanAnnotationMapping.put(cls, true);
		return true;
	}
	
	/**
	 * 校验bean的集合列表
	 * @param bean
	 * @return
	 */
	private ValidateResult doCollectionValidator(Collection<?> bean){
		for(Object itemObj :  bean){
			ValidateResult result = doValidate(itemObj);
			if(!result.isSuccess()){
				return result;
			}
		}
		return ValidateResult.SUCCESS;
	}
	
	/**
	 * 校验数组列表bean
	 * @param bean
	 * @return
	 */
	private ValidateResult doArrayValidator(Object bean){
		int length = Array.getLength(bean);
		for(int i=0;i<length;i++){
			Object tempObj = Array.get(bean, i);
			ValidateResult result = doValidate(tempObj);
			if(!result.isSuccess()){
				return result;
			}
		}
		return ValidateResult.SUCCESS;
	}
	
	private ValidateResult doValidate(Object bean){
		ValidateResult result=  validate(bean);
		if(!result.isSuccess()){
			return result;
		}else{
			return ValidateResult.SUCCESS;
		}
	
	}
	
}
