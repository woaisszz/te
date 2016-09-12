package util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lenovo on 2016/7/15.
 */
public class XaUtil {
    /**
     * 判断对象是否Empty(null或元素为0)<br>
     * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
     *
     * @param
     *      待检查对象
     * @return boolean 返回的布尔值
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object pObj) {
        if (pObj == null)
            return true;
        if (pObj == "")
            return true;
        if (pObj instanceof String) {
            if (((String) pObj).trim().length() == 0) {
                return true;
            }
        } else if (pObj instanceof Collection) {
            if (((Collection) pObj).size() == 0) {
                return true;
            }
        } else if (pObj instanceof Map) {
            if (((Map) pObj).size() == 0) {
                return true;
            }
        }
        return false;
    }

}
