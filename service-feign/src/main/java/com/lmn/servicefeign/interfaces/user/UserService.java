/**
 * Copyright (c) 2020 LIANYIN TECHNOLOGY Inc. All rights reserved.
 */
package com.lmn.servicefeign.interfaces.user;

import com.lmn.servicefeign.model.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @version 0.1
 * @describe:
 * @author:
 * @Date: 2020/4/25 13:07
 */
@Component
public class UserService {
    @HystrixCommand(fallbackMethod = "addError")
    public int add(UserInfo user) {
        return 1;
    }
    public int addError(UserInfo user){
        return 0;
    }

    @HystrixCommand(fallbackMethod = "updateError")
    public int update(UserInfo user) {
        return 1;
    }
    public int updateError(UserInfo user){
        return 0;
    }
}
