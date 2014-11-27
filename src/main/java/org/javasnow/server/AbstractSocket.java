package org.javasnow.server;

import java.net.InetSocketAddress;
import java.util.Iterator;

import org.javasnow.server.socketserver.MinaConfig;

/**
 * 
 * @author cheney
 * @date Nov 27, 2014
 * @time 4:37:07 PM
 * @Version 1.0.0
 */
public abstract class AbstractSocket implements IServer {
	private final MinaConfig minaConfig;

	public AbstractSocket(MinaConfig config) {
		this.minaConfig = config;
	}

	public MinaConfig getMinaConfig() {
		return minaConfig;
	}

	@Override
	public Iterator<InetSocketAddress> iterator() {
		return this.minaConfig.iterator();
	}

	@Override
	public String toString() {
		Iterator<InetSocketAddress> iterator = this.iterator();

		StringBuilder buffer = new StringBuilder(100);
		buffer.append(" MinaSocket ");

		InetSocketAddress socketAddress = null;
		while (iterator.hasNext()) {
			socketAddress = iterator.next();
			buffer.append(" [socketAddress = ").append(socketAddress.getAddress().getHostAddress());
			buffer.append(",listenerPort = ").append(socketAddress.getPort()).append("];");
		}

		return buffer.toString();
	}
}
