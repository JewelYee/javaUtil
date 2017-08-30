package util;

import java.util.List;

/**
 * Created by yee on 2017/8/30.
 */
public class StringUtil {
    /**
     * 将字符串ids数组转换成为List<Long>类型<br>
     * 原始数据："{'ids':[1,2,3]}"<br>
     * 结果数据：List<Long>
     *
     * @param str 原始字符串
     * @return
     */
    @Deprecated
    public static final List<Long> idsToLongList(String str) {
        JSONObject jsonObj = JSON.parseObject(str);
        String idsStr = jsonObj.getString("ids");
        int pos = idsStr.lastIndexOf("]");
        String ids = idsStr.substring(1, pos);
        String[] idsArr = ids.split(",");
        List<Long> idsList = new ArrayList<>();
        for (String idStr : idsArr) {
            idsList.add(Long.valueOf(idStr));
        }
        return idsList;
    }
}
