package com.lmn.servicefeign.interfaces;

import org.springframework.stereotype.Component;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2018-12-11 16:05
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
    
}
