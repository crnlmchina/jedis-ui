package single.yuxuanwang.jedisui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class JedisPoolBeanFactory {

	private ShardedJedisPool jedisPool;

	public ShardedJedisPool getJedisPool() {
		return jedisPool;
	}

	private String conns;

	@PostConstruct
	private void init() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setTestOnBorrow(true);
		String[] hostArr = conns.split(",");
		List<JedisShardInfo> infos = new ArrayList<JedisShardInfo>(hostArr.length);
		for (String host : hostArr) {

			String[] arr = host.split(":");
			infos.add(new JedisShardInfo(arr[0], Integer.parseInt(arr[1]), arr[2]));
		}
		jedisPool = new ShardedJedisPool(jedisPoolConfig, infos);
	}

	public void setConns(String conns) {
		this.conns = conns;
	}

}
