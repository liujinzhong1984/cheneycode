package org.javasnow.service;

import org.json.JSONObject;

/**
 * 公共接口
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:35:46 PM
 * @Version 1.0.0
 */
public interface IService {

	/**
	 * 动作审计
	 * 
	 * @param json
	 * @return
	 */
	public boolean actionAudit(JSONObject json);

	/**
	 * 记录数
	 * 
	 * @return
	 */
	public int getTotalRow();
}
