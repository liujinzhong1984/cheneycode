package org.javasnow.server;

import java.net.InetSocketAddress;
import java.util.Iterator;

/**
 * 监听服务接口
 * 
 * @author cheney
 * @time 2014.11.25
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
