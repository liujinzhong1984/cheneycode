package org.javasnow.validator.vo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VO属性/值转换为Map<K,V>::<属性,值>--<K,V>
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 5:02:46 PM
 * @Version 1.0.0
 */
public class BeanHelper {
	protected static final Logger logger = LoggerFactory.getLogger(BeanHelper.class);
	private static Map<Class<?>, Map<String, Method>> cachedMap = Collections.synchronizedMap(new WeakHashMap<Class<?>, Map<String, Method>>());

	public static Map<String, ?> bean2Map(Object bean) {
		if (bean == null) {
			return Collections.emptyMap();
		}
		Class<?> beanClass = bean.getClass();
		Map<String, Method> nameMethodMap = cachedMap.get(beanClass);
		if (nameMethodMap == null) {
			nameMethodMap = fetchNameMethodMap(beanClass);
			cachedMap.put(beanClass, nameMethodMap);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		for (Map.Entry<String, Method> item : nameMethodMap.entrySet()) {
			try {
				result.put(item.getKey(), item.getValue().invoke(bean));
			} catch (Exception e) {
				throw new RuntimeException("BeanHelper error  : get" + item.getKey() + "() is exist ? ", e);
			}
		}
		return result;
	}

	private static Map<String, Method> fetchNameMethodMap(Class<?> beanClass) {
		Map<String, Method> nameMethodMap = new HashMap<String, Method>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(beanClass);
		} catch (IntrospectionException e) {
			throw new RuntimeException("Introspector.getBeanInfo error : ", e);
		}
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		if (descriptors == null) {
			descriptors = new PropertyDescriptor[0];
		}
		for (PropertyDescriptor item : descriptors) {
			try {
				Method readMethod = item.getReadMethod();
				readMethod.setAccessible(true);
				nameMethodMap.put(item.getName(), readMethod);
			} catch (Exception e) {
				throw new RuntimeException("BeanHelper error  : ", e);
			}
		}
		return nameMethodMap;
	}
}
