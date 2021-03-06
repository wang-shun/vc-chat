package com.vcg.chat.server;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * created by wuyu on 2018/2/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class VcChatServerApplication {

    public static void main(String[] args) throws IOException {
        //pid
        try (FileWriter writer = new FileWriter(new File("VcChatServerApplication.pid"))) {
            String name = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
            writer.write(name);
        }
        SpringApplication.run(VcChatServerApplication.class, args);
    }

}
