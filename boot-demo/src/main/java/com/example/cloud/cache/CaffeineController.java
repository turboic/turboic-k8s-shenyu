package com.example.cloud.cache;

import cn.hutool.core.date.DateUtil;
import com.github.benmanes.caffeine.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/caffeine")
public class CaffeineController {
    private static final Logger log = LoggerFactory.getLogger(CaffeineCacheConfig.class);

    private final String key = "demo";

    @Autowired
    @Qualifier(value = "caffeineCache")
    private Cache<String, Object> caffeineCache;

    @GetMapping(value = "/cache")
    public String cache() {
        caffeineCache.put(key, "缓存内容");
        String time = DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        log.info("时间{}",time);
        return "放入缓存成功"+time;
    }


    @GetMapping(value = "/get")
    public Object get() {
        Object obj = caffeineCache.getIfPresent(key);
        String time = DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        log.info("时间{}",time);
        return (obj == null ? "空" : obj.toString())+time;
    }
}
