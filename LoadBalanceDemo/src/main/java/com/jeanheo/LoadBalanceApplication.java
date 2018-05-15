package com.jeanheo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.SocketException;

/**
 * @author zenghao
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class LoadBalanceApplication {

    private final RestTemplate restTemplate;

    @Autowired
    public LoadBalanceApplication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/ips")
    public String root() throws SocketException {
        String clientRet = restTemplate.getForObject("http://ClientDemo/ips", String.class);
        String localRet = String.format("LoadBalanceDemo's Local ip list = %s", Utils.getLocalIp());
        return String.format("%s\n%s", localRet, clientRet);
    }

}

