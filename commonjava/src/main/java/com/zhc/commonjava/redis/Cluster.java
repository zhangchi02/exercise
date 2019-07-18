package com.zhc.commonjava.redis;

/**
* @author zhangchi02
* @date 2019年4月17日
*/
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.SortingParams;

//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Map;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

/**
 * 集群环境下Jedis操作
 */
public class Cluster {
	private static JedisCluster jedis;
	static {
		// 添加集群的服务节点Set集合
		Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
		// 添加节点
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30001));
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30002));
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30003));
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30004));
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30005));
		hostAndPortsSet.add(new HostAndPort("114.115.236.204 ", 30006));

		// Jedis连接池配置
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 最大空闲连接数, 默认8个
		jedisPoolConfig.setMaxIdle(3);
		// 最大连接数, 默认8个
		jedisPoolConfig.setMaxTotal(500);
		// 最小空闲连接数, 默认0
		jedisPoolConfig.setMinIdle(0);
		// 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
		// 默认-1
		jedisPoolConfig.setMaxWaitMillis(2000); // 设置2秒
		// 对拿到的connection进行validateObject校验
		jedisPoolConfig.setTestOnBorrow(true);
		jedis = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
	}

	/**
	 * 测试key:value数据 集群中flushDB、keys废弃
	 */

	public void testKey() throws InterruptedException {
		// System.out.println("清空数据："+jedis.flushDB());
		System.out.println("判断某个键是否存在：" + jedis.exists("username"));
		System.out.println("新增<'username','wukong'>的键值对：" + jedis.set("username", "xiaohai"));
		System.out.println("是否存在:" + jedis.exists("username"));
		System.out.println("新增<'password','password'>的键值对：" + jedis.set("password", "123456"));
	}
}