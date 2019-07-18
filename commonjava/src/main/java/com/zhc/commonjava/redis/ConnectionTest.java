package com.zhc.commonjava.redis;

import redis.clients.jedis.Jedis;

/**
* @author zhangchi02
* @date 2019年4月22日
*/
public class ConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		singleConn();
	}

	public static void singleConn(){
		// 密码模式创建连接
//		 String host = "114.115.238.219"; 
//		 int port = 6379; 
//		 String pwd = "passwd"; 
//		  
//		 Jedis client = new Jedis(host, port); 
//		 client.auth(pwd);
//		 client.connect(); // 执行set指令
//		 String result = client.set("key-string", "Hello, Redis!"); 
//		 System.out.println( String.format("set指令执行结果:%s", result) ); // 执行get指令
//		 String value = client.get("key-string"); 
//		 System.out.println( String.format("get指令执行结果:%s", value) );

		// 免密模式创建连接
		 String host = "114.115.238.219"; 
		 int port = 6379; 
		  
		 Jedis client = new Jedis(host, port); 
		 client.connect(); // 执行set指令
		 String result = client.set("key-string", "Hello, Redis!"); 
		 System.out.println( String.format("set指令执行结果:%s", result) ); // 执行get指令
		 String value = client.get("key-string"); 
		 System.out.println( String.format("get指令执行结果:%s", value) );
		 client.close();
	}
}
