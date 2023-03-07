package com.develtrex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ClientController {
    @Value("${user.name}")
    private String userName;

    @Value("${message.welcome}")
    private String message;

    @GetMapping("config-client-dev")
    public Response getConfigClient() {
        var response = new Response();
        response.setMessage(message);
        response.setUsername(userName);

        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientController.class, args);
    }
}
