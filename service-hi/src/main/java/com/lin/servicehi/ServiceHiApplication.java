package com.lin.servicehi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace service-hi ");
        return "i'm service-hi";
    }

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @RequestMapping("/miya")
    public String miya() {
        return restTemplate.getForObject("http://SERVICE-MIYA/hi",String.class);
    }

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hello " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hello," + name + ",sorry,error!";
    }
}
