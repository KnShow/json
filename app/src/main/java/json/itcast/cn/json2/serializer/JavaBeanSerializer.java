package json.itcast.cn.json2.serializer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import json.itcast.cn.json2.JsonConfig;
import json.itcast.cn.json2.Utils;

/**
 * javaBean 序列化器
 */
public class JavaBeanSerializer implements ObjectSerializer {

    private final Class beanType;

    public JavaBeanSerializer(Class clazz) {
        beanType = clazz;
        //获取当期类及其父类所有的public成员
        Map<String, Field> cacheFieldMap = new HashMap<>();
        Map<String, Field> fieldMap = Utils.parseAllFiledToCache(cacheFieldMap, clazz);
        //序列化，采集公有getter函数及公有属性
        Utils.computGetter(fieldMap,clazz);
    }

    @Override
    public void serializer(JsonConfig jsonConfig, String json, Object object) {


    }
}
