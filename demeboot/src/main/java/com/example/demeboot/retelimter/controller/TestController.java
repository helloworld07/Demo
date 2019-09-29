package com.example.demeboot.retelimter.controller;

import com.example.demeboot.retelimter.aspect.RateLimitAspect;
import com.example.demeboot.retelimter.entity.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: George
 * @date: 2019/9/25
 * @description:
 */
@RestController
@Slf4j
public class TestController {

    @RateLimitAspect(limitNum = 0.5)
    @RequestMapping("/test01")
    public MyResult getResults() {
        log.info("调用了方法getResults");
        return MyResult.OK("调用了方法", null);
    }

    @RateLimitAspect(limitNum = 2)
    @RequestMapping("/test02")
    public MyResult getResultTwo() {
        log.info("调用了方法getResultTwo");
        return MyResult.OK("调用了方法getResultTwo", null);
    }
}