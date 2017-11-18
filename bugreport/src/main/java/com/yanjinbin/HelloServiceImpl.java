package com.yanjinbin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 吉利不布吉
 * @since 2017/11/18
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void throwNPE(String msg) {
        log.error("要开始抛异常了----嘿嘿");
        System.out.println(msg.toString());
    }
}
