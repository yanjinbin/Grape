package com.yanjinbin.springboot.PropertyValue;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Data
@Component
public class PropertiesValue {
    @Value("${com.yanjinbin.name}")
    private String name;

    @Value("${age}")
    private Integer age;
}
