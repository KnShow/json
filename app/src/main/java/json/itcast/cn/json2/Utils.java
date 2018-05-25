package json.itcast.cn.json2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 序列化工具类
 * 封装一部分常用方法
 */
public class Utils {
    /**
     * 获取clazz及其所有的共有成员
     *
     * @param clazz
     * @param fieldCacheMap 存储了clazz及其父类所有公共成员 属性名及filed字段的map集合
     * @return
     * @method class.getDeclaredFields()  获取该类所有的声明的字段,不包括父类声明的字段,不包括函数
     */
    public static Map<String, Field> parseAllFiledToCache(Map<String, Field> fieldCacheMap, Class clazz) {
        //获取自己所有的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field :
                declaredFields) {
            String name = field.getName();
            if (!fieldCacheMap.containsKey(name)) {
                fieldCacheMap.put(name, field);
            }
        }
        //查找父类
        if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
            parseAllFiledToCache(fieldCacheMap, clazz.getSuperclass());
        }
        return fieldCacheMap;
    }

    /**
     * 序列化，采集公有getter函数及其他公有属性
     * 返回一个封装了所需序列化的数据的集合
     *
     * @param fieldCacheMap
     * @param clazz
     */
    public static void computGetter(Map<String, Field> fieldCacheMap, Class clazz) {
        Map fieldInfoMap = new LinkedHashMap<String, FieldInfo>();
        //1、先获取所有公有函数，再获取所有共有属性
        Method[] methods = clazz.getMethods();
        for (Method method :
                methods) {
            String methodName = method.getName();
            // 静态方法，无返回值方法，返回值为boolean(is),带参方法&&"getClass"
            if (Modifier.isStatic(method.getModifiers()))
                continue;
            if (method.getReturnType().equals(Void.TYPE))
                continue;
            if (method.getParameterTypes().length != 0)
                continue;
            if (methodName.equals("getClass"))
                continue;
            String properTyName;
            if (methodName.startsWith("get")) {
                if (methodName.length() < 4)
                    continue;
                //获取get后的参数名，get后的第一个字母大写转小写
                char c3 = methodName.charAt(3);
                properTyName = Character.toLowerCase(c3) + methodName.substring(3);
                Field field = fieldCacheMap.get(properTyName);
                FieldInfo fieldInfo = new FieldInfo(properTyName, method, field);
                fieldInfoMap.put(properTyName, fieldInfo);
            }

            if (methodName.startsWith("is")) {
                //不是boolean或者Boolean
                if (methodName.length() < 3 || (method.getReturnType() != Boolean.TYPE && method.getReturnType() != Boolean.class))
                    continue;
                char c2 = methodName.charAt(2);
                properTyName = Character.toLowerCase(c2) + methodName.substring(2);
                Field field = fieldCacheMap.get(properTyName);
                FieldInfo fieldInfo = new FieldInfo(properTyName, method, field);
                fieldInfoMap.put(properTyName, fieldInfo);
            }
        }
        //获取所有公有成员
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            //静态的不要
            if (Modifier.isStatic(field.getModifiers()))
                continue;
            //将公有成员添加到集合中
            String properTyName = field.getName();
            if (!fieldInfoMap.containsKey(properTyName)) {
                FieldInfo fieldInfo = new FieldInfo(properTyName, null, field);
                fieldInfoMap.put(properTyName, fieldInfo);
            }
        }
    }
}
