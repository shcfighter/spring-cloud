package cloud.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/*
 * @author shc_fighter
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthServiceApplication.class, args);
    }
}