package cloud.simple.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/*
 * @author zhangpeng
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class SimpleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceApplication.class, args);
    }
}