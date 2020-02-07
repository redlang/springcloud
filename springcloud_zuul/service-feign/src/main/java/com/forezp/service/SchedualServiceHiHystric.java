package com.forezp.service;

import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
//断路器
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
