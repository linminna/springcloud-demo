/**
 * Copyright (c) 2020 LIANYIN TECHNOLOGY Inc. All rights reserved.
 */
package com.lmn.servicefeign.web;

import com.lmn.servicefeign.interfaces.user.UserService;
import com.lmn.servicefeign.model.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 0.1
 * @describe:
 * @author:
 * @Date: 2020/4/25 13:08
 */
@RestController
@EnableHystrix
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("添加用户")
    @GetMapping("/add")
    public int addUser(UserInfo user) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.add(user);
    }

    @ApiOperation("更新用户")
    @PostMapping("/update")
    public int update(@RequestBody UserInfo user) {
        return userService.update(user);
    }

}
