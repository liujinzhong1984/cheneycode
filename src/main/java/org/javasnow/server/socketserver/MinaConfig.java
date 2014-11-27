package org.javasnow.server.socketserver;

import java.net.InetSocketAddress;
import java.util.Iterator;

/**
 * 监听端口设置
 * 
 * @author cheney
 * @time 2014.11.25
 */
public class MinaConfig implements Iterable<InetSocketAddress> {
	private final int[] port;
	private InetSocketAddress[] socketAddress;

	public MinaConfig(int... port) {
		super();
		this.port = port;
	}

	private synchronized InetSocketAddress[] getSocketAddress() {
		if (socketAddress == null) {
			socketAddress = new InetSocketAddress[port.length];
			for (int i = 0, len = port.length; i < len; i++)
				socketAddress[i] = new InetSocketAddress(port[i]);
		}

		return socketAddress;
	}

	@Override
	public Iterator<InetSocketAddress> iterator() {
		return sIterator;
	}

	private SocketIterator sIterator = new SocketIterator(this.getSocketAddress());

	class SocketIterator implements Iterator<InetSocketAddress> {
		private int index = 0;
		private InetSocketAddress[] socketAddress;

		public SocketIterator(InetSocketAddress[] socketAddress) {
			this.socketAddress = socketAddress;
		}

		@Override
		public boolean hasNext() {
			return index != socketAddress.length;
		}

		@Override
		public InetSocketAddress next() {
			// index++先赋值再++即index=0;b=index++;结果预期b=0,index=1;
			return socketAddress[index++];
		}

		@Override
		public void remove() {
		}
	}

}
