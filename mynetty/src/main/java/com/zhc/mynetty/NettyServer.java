package com.zhc.mynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {
	public static void main(String[] args) {

		// 表示监听端口，accept新连接的线程组
		NioEventLoopGroup boss = new NioEventLoopGroup();
		// 表示处理每一条连接的数据读写的线程组
		NioEventLoopGroup worker = new NioEventLoopGroup();

		// 引导类，引导我们进行服务端的启动工作
		ServerBootstrap serverBootstrap = new ServerBootstrap();

		serverBootstrap
				// 1.给引导类配置两大线程组，引导类的线程模型也就定型了
				.group(boss, worker)
				// 2.指定服务端的 IO 模型为NIO
				.channel(NioServerSocketChannel.class)
				// 3.定义后续每条连接的数据读写，业务处理逻辑
				.childHandler(new ChannelInitializer<NioSocketChannel>() {
					protected void initChannel(NioSocketChannel ch) {
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
							@Override
							protected void channelRead0(ChannelHandlerContext ctx, String msg) {
								System.out.println(msg);
							}
						});
					}
				});
		bind(serverBootstrap, 8000);
	}

	// 自动绑定递增端口
	private static void bind(final ServerBootstrap serverBootstrap, final int port) {
		serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
			public void operationComplete(Future<? super Void> future) {
				if (future.isSuccess()) {
					System.out.println("端口[" + port + "]绑定成功!");
				} else {
					System.err.println("端口[" + port + "]绑定失败!");
					bind(serverBootstrap, port + 1);
				}
			}
		});
	}
}
