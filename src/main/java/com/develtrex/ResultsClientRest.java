package com.develtrex;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "config-client-two", url = "http://localhost:8080")
public interface ResultsClientRest {
    @GetMapping("results/{number}")
    String showResult(@PathVariable float number);
}
