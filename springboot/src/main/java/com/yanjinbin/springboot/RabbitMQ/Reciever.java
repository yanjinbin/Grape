package com.yanjinbin.springboot.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * http://blog.didispace.com/spring-boot-rabbitmq/
 *
 * @author Silver & Bullet
 *         on 三月-04
 */
@Component
@RabbitListener(queues = "hello")
public class Reciever {
    @RabbitHandler
    public void process(String hello){
        System.out.println("hello say"+hello);

    }
}
