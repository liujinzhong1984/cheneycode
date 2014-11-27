package org.javasnow.service;

/**
 * 登录帐户信息
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:34:43 PM
 * @Version 1.0.0
 */
public class LoginUser implements java.io.Serializable {
	private static final long serialVersionUID = 127323489722564256L;
	private String loginName;// 全局唯一
	private String loginPwd;// 此处是密文表示
	private long userPhone;// 手机号,可以不填,如果填则全局唯一
	private String userEmail;// 个人邮箱,可以不填,如果填则全局唯一

	public LoginUser() {
		super();
	}

	public LoginUser(String loginName, String loginPwd) {
		super();
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
