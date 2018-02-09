package com.zhangkenan.zkui.test.redis;

import java.util.concurrent.TimeUnit;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisLockMain {
	
	public static void main(String[] args) {
		//创建jedis池配置实例  
        JedisPoolConfig config = new JedisPoolConfig();   
        //设置池配置项值  
        config.setMaxTotal(1024);    
        config.setMaxIdle(200);    
        config.setMaxWaitMillis(1000);    
        config.setTestOnBorrow(true);    
        config.setTestOnReturn(true); 
        
        //根据配置实例化jedis池  
        JedisPool  pool = new JedisPool(config,"127.0.0.1", 6379);  
        IRedisLockHandler lock = new RedisLockHandler(pool);
        if(lock.tryLock("abcd",20,TimeUnit.SECONDS)){
        	System.out.println(" get lock ...");
        }else{
        	System.out.println(" not get lock ...");
        }
       lock.unLock("abcd");

	}

}