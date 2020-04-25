package com.lmn.servicefeign.web;

import com.lmn.servicefeign.interfaces.SchedualServiceHi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: com.lmn.lmntest
 * @description:
 * @author: linminna
 * @create: 2018-12-11 15:45
 **/
@Api(description = "feign-hi")
@RestController
public class HiController {

    @Resource
    SchedualServiceHi schedualServiceHi;

    @ApiOperation(value = "sayHi")
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return "I'm come from feign, " + schedualServiceHi.sayHiFromClientOne(name);
    }
}
