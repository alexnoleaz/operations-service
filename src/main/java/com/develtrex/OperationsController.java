package com.develtrex;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class OperationsController {
    @Value("${user.name}")
    private String userName;

    @Value("${message.welcome}")
    private String message;

    @Autowired
    private ResultsClientRest resultsClientRest;

    @HystrixCommand(fallbackMethod = "fallbackError")
    @GetMapping("operations/{a}/{b}")
    public String getOperations(@PathVariable float a, @PathVariable float b){
        return resultsClientRest.showResult(a-b);
    }

    public static void main(String[] args) {
        SpringApplication.run(OperationsController.class, args);
    }

    private String fallbackError(float a, float b){
        return "We are having server problems, please try again at a later time.";
    }
}
