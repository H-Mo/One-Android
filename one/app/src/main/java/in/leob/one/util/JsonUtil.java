package in.leob.one.util;

import com.alibaba.fastjson.JSON;

/**
 * @author leobin
 * @time 2016/11/10  11:51
 * @desc json解析工具类
 */
public class JsonUtil {
    public static <T> T parseJson(String json, Class<T> tClass) {
        return JSON.parseObject(json,tClass);
    }
}
