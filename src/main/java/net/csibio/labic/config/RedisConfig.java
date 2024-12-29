package net.csibio.labic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 暂时未使用Redis,用于缓存Aird文件的时候性能较低
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置键（key）的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置值（value）的序列化器
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 设置哈希键（hash key）的序列化器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 设置哈希值（hash value）的序列化器
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}

