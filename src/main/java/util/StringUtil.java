package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.*;

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


    public static final Boolean isEmpty(String str){
        return (str == null || "".equals(str) || str.length() == 0);
    }

    /**
     * key:content需要替换的文本模板
     * @param params
     * @return
     */
    public static final String replace(Map<String, Object> params){
        PropertyPlaceholderHelper placeholder = new PropertyPlaceholderHelper( "#", "#" );
        // 例:【蚂蚁借呗】你的支付宝#accountNo#将从余额、储蓄卡或余额宝自动还款#money#元
        String content = params.get("content").toString();
        params.remove("content");

        return placeholder.replacePlaceholders(content, new PropertyPlaceholderHelper.PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(String placeholderName) {
                return params.get(placeholderName).toString();
            }
        });
    }

    /**
     * key:content需要替换的文本模板
     * @param properties
     * @return
     */
    public String getContent(Properties properties) {

        PropertyPlaceholderHelper placeholder = new PropertyPlaceholderHelper( "#", "#" );
        // 例:【蚂蚁借呗】你的支付宝#accountNo#将从余额、储蓄卡或余额宝自动还款#money#元
        String content = properties.get("content").toString();
        properties.remove("content");

        return placeholder.replacePlaceholders(content, properties);
    }

    /**
     * String 转换 String数组
     * @param str 例："1,2,3,4,a,s,d"
     * @return
     */
    public String[] stringToArray(String str){
        return str.split(",");
    }

    /**
     * List<String> 转 String数组
     * @param list
     * @return
     */
    public String[] listToArray(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : list) {
            stringBuilder.append(str + ",");
        }
        return  stringBuilder.toString().split(",");
    }

}
