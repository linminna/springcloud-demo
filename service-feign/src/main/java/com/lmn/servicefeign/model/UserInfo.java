/**
 * Copyright (c) 2020 LIANYIN TECHNOLOGY Inc. All rights reserved.
 */
package com.lmn.servicefeign.model;

/**
 * @version 0.1
 * @describe:
 * @author:
 * @Date: 2020/4/25 12:53
 */
public class UserInfo {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
