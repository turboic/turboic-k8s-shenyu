package com.example.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author test
 */

@SpringBootApplication
@EnableScheduling
public class AppApplication {
    private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

    public static void main(String[] args) {
        log.error("k8s部署演示程序正在启动 ......");
        log.error("-----------------------------------------程序上下文boot-demo-----------------------------------------");
        log.error("-----------------------------------------访问端口9277--------------------------------");

        log.error("-----------------------------------------mysql数据库，boot-demo，用户名root，密码123456--------------------------------");

        log.error("-----------------------------------------mysql数据库boot-demo，需要提前创建--------------------------------");

        log.error("-----------------------------------------测试接口地址-----------------------------------------");
        log.error("1、   http://localhost:9277/boot-demo/main/list");
        log.error("2、   http://localhost:9277/boot-demo/main/ip");
        log.error("3、   http://localhost:9277/boot-demo/main/video");
        log.error("4、   http://localhost:9277/boot-demo/main/byId/1");
        log.error("5、   http://localhost:9277/boot-demo/main/info");
        log.error("-----------------------------------------测试接口地址-----------------------------------------");
        log.error("6、   http://localhost:9277/boot-demo/actuator/caches");
        log.error("7、   http://localhost:9277/boot-demo/actuator/env");
        log.error("8、   http://localhost:9277/boot-demo/actuator/beans");
        log.error("9、   http://localhost:9277/boot-demo/actuator/threaddump");
        log.error("10、   http://localhost:9277/boot-demo/actuator/health");


        new SpringApplicationBuilder(AppApplication.class).run(args);
    }
}
