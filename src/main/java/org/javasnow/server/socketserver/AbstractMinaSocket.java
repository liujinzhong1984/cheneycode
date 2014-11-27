package org.javasnow.server.socketserver;

import java.net.InetSocketAddress;
import java.util.Iterator;

import org.javasnow.server.IServer;

/**
 * 
 * @author cheney
 * @time 2014.11.26
 */
public abstract class AbstractMinaSocket implements IServer {
	private final MinaConfig minaConfig;

	public AbstractMinaSocket(MinaConfig config) {
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
