package org.javasnow.validator;

/**
 * 
 * @author cheney
 * @date Nov 28, 2014
 * @time 10:23:55 AM
 * @Version 1.0.0
 */
public abstract class AbsValidatorEnum {

	/**
	 * 规则名字枚举
	 */
	public enum RuleType {
		/**
		 * empty:str==null||str.length==0
		 * blank:str==null||str.length==0||str.trim().length==0
		 * */
		EMPTY, NOT_EMPTY, BLANK, NOT_BLANK,

		/** 正则验证 */
		STRING_REGEX,

		/** 格式校验 */
		NUMBER_FORMAT, DATE_FORMAT,

		/**
		 * 和当前时间比较 <br>
		 * 规则：<br>
		 * 1、必须有,号分隔 <br>
		 * 2、必须有比较字符 <br>
		 * eg: <br>
		 * ">=,yyyy-MM-dd" 逗号分隔后,参数1表示判断标准;参数2表示时间格式
		 * */
		DATE_COMPARE_NOW,

		/**
		 * 字符串长度限制 <br>
		 * 规则：<br>
		 * 1、开始第一个字符为[时最后一个字符必须为];开始第一个字符为(时最后一个字符必须为) <br>
		 * 2、中间必须有',' 字符 <br>
		 * eg: <br>
		 * 1、[10,20]/(10,20)--最小长度和最大长度均限制 <br>
		 * 2、[10,]/(10,)--仅限制最小长度 <br>
		 * 3、[,20]/(,20)--仅限制最大长度 <br>
		 * */
		STRING_LENGTH_LIMIT,

		/**
		 * 值区间限制 <br>
		 * 规则同字符串长度限制
		 * */
		NUMBER_VALUE_LIMIT,

		/** 取模限制 eq:"5,3" */
		NUMBER_VALUE_MOD,

		/**
		 * 可取值范围限制 列表用',' 分割<br>
		 * eg: value = "0,1,5" 那么仅能取值 0或在1或5 才能通过
		 * */
		VALUES_COLLECTION_LIMIT,

		/** 二元 依赖限制 */

		/**
		 * eg: value = "referProperty,>="
		 * */
		NUMBER_COMPARE_REFER,
		/**
		 * 数据参考比较 <br>
		 * eg： <br>
		 * value = "startDate,>,yyyy-MM-dd" <br>
		 * value = "startDate,>=,yyyy-Mm-dd" <br>
		 * value = "startDate,=,yyyy-MM-dd"
		 * */
		DATE_COMPARE_REFER,

		/** 本地自定义验证器 */
		LOCAL_TYPE
	}

	public enum BoundryType {
		EQUALS, BIGANDEQUAL, BIG, LESS, LESSANDEQUAL
	}

	/**
	 * 提醒类型
	 */
	public enum TipType {
		/** 仅提醒rule上的规则 */
		JUST_RULE,
		/** 会使用rules上的字段文本+rule上的规则文本 */
		COMBINE
	}

	/** 规则校验结果 */
	public enum NextStepType {
		RETURNSUCCESS, RETURNFAIL, GONEXT
	}

	/** 逻辑组合模式 */
	public enum LogicAssembleType {
		OR, AND
	}

	public enum TargetType {
		SIMPLE, COMPLEX
	}
}
