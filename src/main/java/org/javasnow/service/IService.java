package org.javasnow.service;

/**
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:35:46 PM
 * @Version 1.0.0
 */
public interface IService {
	public LoginUser getLoginUserByLoginName();

	public LoginUser getLoginUserByUserPhone();

	public LoginUser getLoginUserByUserEmail();
}
