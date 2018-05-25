package json.itcast.cn.json2;

import java.lang.reflect.Type;

/**
 * 序列化/反序列化 工具类，隐藏内部实现，对外提供功能实现方法。
 */
public class Json {
    /**
     * @param object
     * @return 序列化---------------------------------------------------------
     */
    public static String JsonToString(Object object) {
        //
        return "";
    }

    /**
     * @param object
     * @param jsonConfig 可自定义，内部也有实现
     * @return
     */
    public static String JsonToString(Object object, JsonConfig jsonConfig) {
        return "";
    }


//-------------------------------------------------------------------------------------------

    /**
     * 反序列化
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T parse(String json, Type type) {
        return null;
    }

    public static <T> T parse(String json, Class<T> t) {
        return null;
    }

}
