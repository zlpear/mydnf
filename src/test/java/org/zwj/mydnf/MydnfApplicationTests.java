package org.zwj.mydnf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MydnfApplicationTests {


    private final Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)                             // 设置缓存的最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES)       // 设置缓存在写入10分钟后失效
            .build();;

    @Test
    void contextLoads() {
        cache.put("a", "a");
        System.out.println(cache.getIfPresent("a"));
    }

}
