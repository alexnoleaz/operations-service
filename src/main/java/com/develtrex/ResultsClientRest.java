package com.develtrex;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "results-service", url = "http://localhost:8082/api/results")
public interface ResultsClientRest {
    @GetMapping("/{number}")
    String showResult(@PathVariable float number);
}
