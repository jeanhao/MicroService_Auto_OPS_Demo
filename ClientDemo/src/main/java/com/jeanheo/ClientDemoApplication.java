package com.jeanheo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;

/**
 * @author zenghao
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientDemoApplication.class, args);
    }


    @RequestMapping(value = "/ips")
    public String root() throws SocketException {
        return String.format("ClientDemo's Local ip list = %s", Utils.getLocalIp());
    }

}

