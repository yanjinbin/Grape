/*
package Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.Date;

*/
/**
 * @author xiaobin
 * @since 05-17
 *//*

public class JacksonTry {
    public static void main(String[] args) throws JsonProcessingException {
        Student s = new Student();
        s.setAge(11);
        s.setBirthDay(new Date());
        s.setName("香港记者");
        s.setClass_id(99);
        ObjectMapper mapper = new ObjectMapper();
        // {"age":11,"name":"香港记者","birthday":1526531377821,"class_id":99}
        */
/*mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
        System.out.println(mapper.writeValueAsString(s));*//*

        // {"age":11,"name":"香港记者","birth-day":1526531331178,"class_id":99}
        */
/*mapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        System.out.println(mapper.writeValueAsString(s));*//*

        //  {"age":11,"name":"香港记者","birthDay":1526531279814,"class_id":99}
        */
/*mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        System.out.println(mapper.writeValueAsString(s));*//*

        // {"Age":11,"Name":"香港记者","BirthDay":1526531473186,"Class_id":99}
       */
/* mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        System.out.println(mapper.writeValueAsString(s));*//*

        // {"age":11,"name":"香港记者","birth_day":1526531421062,"class_id":99}
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        System.out.println(mapper.writeValueAsString(s));


    }
}
*/
