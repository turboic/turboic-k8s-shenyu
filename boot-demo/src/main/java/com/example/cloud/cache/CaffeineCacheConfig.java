package com.example.cloud.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


@Configuration
public class CaffeineCacheConfig {
    private static final Logger log = LoggerFactory.getLogger(CaffeineCacheConfig.class);



    @Bean(value = "caffeineCache")
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .expireAfter(new Expiry<String, Object>() {
                    @Override
                    public long expireAfterCreate(@NonNull String s, @NonNull Object o, long l) {
                        TimeUnit timeUnit = TimeUnit.MINUTES;
                        long l1 = timeUnit.toNanos(100);
                        log.info("expireAfterCreate:"+l);
                        return l1;
                    }

                    @Override
                    public long expireAfterUpdate(@NonNull String s, @NonNull Object o, long currentTime, @NonNegative long currentDuration) {
                        return currentDuration;
                    }

                    @Override
                    public long expireAfterRead(@NonNull String s, @NonNull Object o, long currentTime, @NonNegative long currentDuration) {
                        return currentDuration;
                    }
                }).build();
    }

}