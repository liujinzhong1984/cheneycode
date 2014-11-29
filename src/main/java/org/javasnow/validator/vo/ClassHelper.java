package org.javasnow.validator.vo;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.ArrayUtils;
import org.javasnow.validator.annotation.ValidatorRules;

/**
 * Class相关工具类
 * 
 * @author xinchun.wang
 * 
 */
public class ClassHelper {

	/**
	 * 检索cls类的所有Field字段以及其上的验证信息
	 * 
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Field, ValidatorRules> getFieldsAndRules(Class<?> cls) {
		if (cls == null) {
			return Collections.EMPTY_MAP;
		}

		final Field[] fields = cls.getDeclaredFields();
		if (fields == null) {
			return Collections.EMPTY_MAP;
		}
		
		Map<Field, ValidatorRules> fieldRulesMap = new TreeMap<Field, ValidatorRules>(
				new Comparator<Field>() {
					@Override
					public int compare(Field o1, Field o2) {
						ValidatorRules rules1 = o1.getAnnotation(ValidatorRules.class);
						ValidatorRules rules2 = o2.getAnnotation(ValidatorRules.class);
						if (rules1.order() != Integer.MIN_VALUE && rules2.order() != Integer.MIN_VALUE) { //如果两个都有配置顺序
							if(rules1.order() == rules2.order()) { //都配置，但是配置的order顺序相等
								int index1 = ArrayUtils.indexOf(fields,o1);
								int index2 = ArrayUtils.indexOf(fields,o2);
								return index1 - index2;
							}
							return rules1.order() - rules2.order(); //都配置，order小的排在前面
						} else if (rules1.order() == Integer.MIN_VALUE) { //o1 没有配置，o2配置了
							return 1;
						} else if (rules2.order() == Integer.MIN_VALUE) { //o1 配置了，o2没有配置了
							return -1;
						}else {
							int index1 = ArrayUtils.indexOf(fields,o1);
							int index2 = ArrayUtils.indexOf(fields,o2);
							return index1 - index2;
						}
					}
				});

		for (Field item : fields) {
			ValidatorRules ValidatorRules = item.getAnnotation(ValidatorRules.class);
			if (ValidatorRules == null) {
				continue;
			}
			fieldRulesMap.put(item, ValidatorRules);
		}
		return fieldRulesMap;
	}
}
