package com.lmn.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard  //Dashboard启用监控
@EnableCircuitBreaker  //启用熔断、断路器功能
@EnableTurbine  //启用Turbine
public class ServiceTurbineApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ServiceTurbineApplication.class, args);
        new SpringApplicationBuilder(ServiceTurbineApplication.class).run(args);
    }

}

