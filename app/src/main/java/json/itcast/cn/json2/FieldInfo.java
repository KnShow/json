package json.itcast.cn.json2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldInfo {
    private String name;
    private Method method;
    private Field field;
    private Class classType;

    public Class getClassType() {
        return classType;
    }

    public FieldInfo(String name, Method method, Field field) {
        this.name = name;
        this.method = method;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
