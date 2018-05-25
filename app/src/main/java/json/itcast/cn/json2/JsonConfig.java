package json.itcast.cn.json2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import json.itcast.cn.json2.serializer.ObjectSerializer;

/**
 * 序列化器管理类,定义一个map集合来缓存序列化器，避免重复操作。
 */
public class JsonConfig {
    public static final JsonConfig globalIzInstance = new JsonConfig();
    //序列化器缓存
    private static Map<Class, ObjectSerializer> serializers = new HashMap();

    public JsonConfig getInstance() {
        return globalIzInstance;
    }

    public ObjectSerializer getSerializer(Class<?> clazz) {

        return null;
    }
}
