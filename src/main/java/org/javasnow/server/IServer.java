package org.javasnow.server;

import java.net.InetSocketAddress;
import java.util.Iterator;

/**
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:37:27 PM
 * @Version 1.0.0
 */
public interface IServer {

	/**
	 * 启动服务
	 * 
	 * @param port
	 */
	public void start() throws Exception;

	/**
	 * 停止服务
	 * 
	 * @param port
	 */
	public void stop() throws Exception;

	/**
	 * 遍历网络信息
	 * 
	 * @return
	 */
	public Iterator<InetSocketAddress> iterator();

}
