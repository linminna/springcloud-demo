package com.lmn.servicefeign.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient  value用来指定调用的服务
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)//
public interface SchedualServiceHi {
    
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
    
    
}
