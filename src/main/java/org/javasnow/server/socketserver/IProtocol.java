package org.javasnow.server.socketserver;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.transport.socket.SocketConnector;

/**
 * 网络通讯协议接口
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:35:58 PM
 * @Version 1.0.0
 */
public interface IProtocol {
	/**
	 * 返回协议名称
	 * 
	 * @return
	 */
	public String getProtocolName();

	/**
	 * 服务器端协议解码编码
	 * 
	 * @param acceptor
	 */
	public void setProtocol(IoAcceptor acceptor);

	/**
	 * 客户端协议解码编码
	 * 
	 * @param connector
	 */
	public void setProtocol(SocketConnector connector);
}
