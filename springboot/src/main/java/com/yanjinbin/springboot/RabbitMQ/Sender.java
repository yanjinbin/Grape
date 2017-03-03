package com.yanjinbin.springboot.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Silver & Bullet
 *         on 三月-04
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitMQ;

    public void sendHello(){
        String text ="hello"+ LocalDateTime.now();
        rabbitMQ.convertAndSend("hello",text);
    }
}
