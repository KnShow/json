package json.itcast.cn.json2.serializer;

import json.itcast.cn.json2.JsonConfig;

/**
 * 序列化/反序列化 器接口
 */
public interface ObjectSerializer {
    /**
     *
     * @param jsonConfig
     * @param json  json字符串
     *
    [
    [
    {"age":100,"list":["1","2"],"test":1},
    {"age":200,"list":["1","2"],"test":1}
    ],
    [{"age":300,"childs":[{"age":3100,"list":["1","2"],"test":1},
    {"age":3200,"list":["1","2"],"test":1}
    ],
    "list":["1","2"],
    "test":1},
    {"age":400,"list":["1","2"],"test":1}
    ]
    ]
     * @param object
     */
    void serializer(JsonConfig jsonConfig, String json, Object object);
}
