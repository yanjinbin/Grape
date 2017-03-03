package springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
public class FastJSONSerilizable<V> implements RedisSerializer<V> {
    @Override
    public byte[] serialize(V v) throws SerializationException {
        if (v == null) {
            return new byte[0];
        }
        return JSON.toJSONBytes(v, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public V deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null) {
            return null;
        }
        return null;
        //  return JSON.parseObject(bytes,SerializerFeature.DisableCircularReferenceDetect);
    }
}
