package org.javasnow.validator;

import java.util.Map;

/**
 * VO属性/值转换为Map格式<K,V>--<属性,值>
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 4:06:42 PM
 * @Version 1.0.0
 */
public interface IConvertMap {
	public Map<String, ?> toMap();
}
