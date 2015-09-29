package single.yuxuanwang.jedisui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import single.yuxuanwang.jedisui.ComponentRegedit;
import single.yuxuanwang.jedisui.JedisPoolBeanFactory;

public class ClearActionListener implements ActionListener {

	@Autowired
	private JedisPoolBeanFactory jedisPoolBeanFactory;

	@Override
	public void actionPerformed(ActionEvent e) {
		ShardedJedisPool jedisPool = jedisPoolBeanFactory.getJedisPool();
		ShardedJedis resource = null;
		try {
			resource = jedisPool.getResource();
			Collection<Jedis> shards = resource.getAllShards();
			for (Jedis shard : shards) {
				shard.flushAll();
			}
			
			JButton findBt = ComponentRegedit.get("findBt");
			findBt.doClick();

			JButton regexBt = ComponentRegedit.get("regexBt");
			regexBt.doClick();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (resource != null)
				jedisPool.returnResource(resource);
		}
	}

}
