package com.jeanheo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

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

    public static String getLocalIp() throws SocketException {
        String ipString = "";
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = allNetInterfaces.nextElement();
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = addresses.nextElement();
                if (ip instanceof Inet4Address && !"127.0.0.1".equals(ip.getHostAddress())) {
                    return ip.getHostAddress();
                }
            }
        }
        return ipString;
    }


    @RequestMapping(value = "/")
    public String root() throws SocketException {
        return String.format("Hello! My local-ip is %s", getLocalIp());
    }

}

