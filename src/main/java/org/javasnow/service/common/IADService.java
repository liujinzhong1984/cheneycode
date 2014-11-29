package org.javasnow.service.common;

import org.javasnow.service.IService;
import org.javasnow.service.LoginUser;
/**
 * 帐户/部门接口
 * 
 * @author cheney
 * @date Nov 29, 2014
 * @time 9:23:02 AM
 * @Version 1.0.0
 */
public interface IADService extends IService {
	public LoginUser getLoginUserByLoginName(String loginName);

	public LoginUser getLoginUserByUserPhone(long userPhone);

	public LoginUser getLoginUserByUserEmail(String userEmail);

}
