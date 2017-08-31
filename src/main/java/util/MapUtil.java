package util;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by yee on 2017/8/30.
 */
public class MapUtil {
    /**
     * map的key 转List
     *
     * @param map
     * @return
     */
    public static final <T> List<T> mapKeyToList(Map<T, T> map) {
        return new ArrayList<T>(map.keySet());
    }

    /**
     * map的value 转List
     *
     * @param map
     * @return
     */
    public static final <T> List<T> mapValueToList(Map<T, T> map) {
        return new ArrayList<T>(map.values());
    }

    /**
     * map的value Set
     *
     * @param map
     * @return
     */
    public static final <T> Set<T> mapKeyToSet(Map<T, T> map) {
        return map.keySet();
    }

    /**
     * map的value Set
     *
     * @param map
     * @return
     */
    public static final <T> Set<T> mapValueToSet(Map<T, T> map) {
        return new HashSet<T>(map.values());
    }

    /**
     * map 转 list
     *
     * @param list
     * @param <T>
     * @return KEY为 Integer类型
     */
    public static final <T> Map<Integer, T> listToMap(Iterable<T> list) {
        Map<Integer, T> map = new HashMap<Integer, T>();
        int i = 0;
        for (Iterator<T> it = list.iterator(); it.hasNext(); i++) {
            map.put(i, it.next());
        }
        return map;
    }

    public static final Boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }
}
