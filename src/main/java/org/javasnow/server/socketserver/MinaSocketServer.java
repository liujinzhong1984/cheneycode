package org.javasnow.server.socketserver;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * 网络通讯服务端
 * 
 * @author cheney
 * @time 2014.11.25
 */
public class MinaSocketServer extends AbstractMinaSocket {
	private IoAcceptor acceptor = null;
	private IoHandler handler = null;
	private IProtocol protocol = null;

	public MinaSocketServer(MinaConfig config, IoHandler handler, IProtocol protocol) {
		super(config);
		this.handler = handler;
		this.protocol = protocol;
	}

	@Override
	public void start() throws Exception {
		this.acceptor = new NioSocketAcceptor(Runtime.getRuntime().availableProcessors() + 1);

		// 参数配置
		this.acceptor.getSessionConfig().setMinReadBufferSize(1024);
		this.acceptor.getSessionConfig().setMaxReadBufferSize(1024 * 5);
		this.acceptor.getSessionConfig().setBothIdleTime(10);
		((SocketSessionConfig) this.acceptor.getSessionConfig()).setSoLinger(0);// 避免服务器出现大量TIME_WAIT状态

		// 日志级别设置
		LoggingFilter logFilter = new LoggingFilter();
		logFilter.setSessionCreatedLogLevel(LogLevel.DEBUG);
		logFilter.setSessionOpenedLogLevel(LogLevel.DEBUG);
		logFilter.setSessionIdleLogLevel(LogLevel.DEBUG);
		logFilter.setExceptionCaughtLogLevel(LogLevel.ERROR);
		logFilter.setMessageReceivedLogLevel(LogLevel.INFO);
		logFilter.setMessageSentLogLevel(LogLevel.DEBUG);

		this.protocol.setProtocol(acceptor);
		this.acceptor.setHandler(handler);

		// 绑定通信端口
		this.acceptor.bind(this.getMinaConfig());
	}

	@Override
	public void stop() throws Exception {
		acceptor.dispose(true);
		acceptor.unbind(this.getMinaConfig());
	}

}
