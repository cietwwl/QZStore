package com.ks.login.kernel;

import java.net.InetSocketAddress;
import java.sql.Timestamp;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.ks.app.Application;
import com.ks.logger.LoggerFactory;
import com.ks.protocol.codec.message.MessageDecoder;
import com.ks.protocol.vo.Head;
import com.ks.rpc.RPCKernel;
import com.ks.rpc.client.RPCClient;

/**
 * 
 * @author ks
 *
 */
public final class QZLoginServerKernel {
	private static final Logger logger = LoggerFactory.get(QZLoginServerKernel.class);
	private static void init() throws Exception{
		Application application = new Application();
		application.init("QZLoginApplication.xml",application);
		logger.info("init application");
		RPCClient client = new RPCClient(new InetSocketAddress(Application.WORLD_SERVER_HOST,
				Application.WORLD_SERVER_PORT), "", Application.WORLD_SERVER);
		RPCKernel.addRPCClient(client);
	}
	private static void start() throws Exception{
		init();
		logger.info("start server");
		Executor bossExecutor = Executors.newCachedThreadPool();
		Executor workExecutor = Executors.newCachedThreadPool();
		ChannelFactory factory = new NioServerSocketChannelFactory(bossExecutor,workExecutor);
		ServerBootstrap bootstrap = new ServerBootstrap(factory);
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			public ChannelPipeline getPipeline() {
				ChannelPipeline popeline = Channels.pipeline();
				popeline.addLast("decoder", new MessageDecoder(Head.class));
				popeline.addLast("handler", new LoginServerHandler());
				return popeline;
			}
		});
		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);
		bootstrap.bind(new InetSocketAddress(Application.PORT));
		logger.info("server port:"+Application.PORT);
	}
	public static void main(String[] args) throws Exception {
		final long start = System.currentTimeMillis();
		try{
			start();
		}catch(Exception e){
			logger.error("",e);
			System.exit(-1);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				logger.info("Login Server shut down..");
				logger.info("start run time : " + new Timestamp(start));
				logger.info("end run time ->" + new Timestamp(System.currentTimeMillis()));
			}
		}));
	}
}
