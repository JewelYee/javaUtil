package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yee on 2017/8/30.
 */
public class DateUtil {
    /**
     * 字符串：yyyy-MM-dd HH:mm:ss
     */
    public static final String currentDatetimeStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 字符串：yyyyMMddHHmmssSSS
     */
    public static final String currentDatetimeStrNoFomat() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    public static final String currentDateStr() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当前时间之前N天的具体时间（特别注意，会包含当前时间）
     * <p>
     * 如果今天是 '2017-01-02'，那么调用函数 {@code getDaysBeforeFromNow( 1 )} 将输出
     * Date('2017-01-01')
     * </p>
     *
     * @param howDays
     *            具体向前推多少天
     * @return {@link java.util.Date} N天前的具体日期
     */
    public static final Date getDaysBeforeFromNow(int howDays) {
        return getDaysBefore(new Date(), howDays);
    }

    /**
     * 获取指定时间之前N天的具体时间（特别注意，会包含源时间）
     *
     * @param source
     *            指定的具体日期
     * @param howDays
     *            具体向前推多少天
     * @return {@link java.util.Date} N天前的具体日期
     */
    public static final Date getDaysBefore(Date source, int howDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.add(Calendar.DAY_OF_MONTH, howDays);
        return calendar.getTime();
    }

    /**
     * 获取当前时间之前N天的每一天时间（特别注意，会包含当前时间）
     * <p>
     * 如果今天是 '2017-01-02'，那么调用函数 {@code getDaysBeforeFromNow( 1 )} 将输出 [
     * Date('2017-01-02'), Date('2017-01-01') ]
     * </p>
     *
     * @param howDays
     *            具体向前推多少天
     * @param isIncludingTarget
     *            是否包含指定日期
     * @return {@link java.util.Date} N天前的具体日期
     */
    public static final List<Date> getDaysBeforeListFromNow(int howDays, boolean isIncludingTarget) {
        return getDaysBeforeList(new Date(), howDays, isIncludingTarget);
    }

    /**
     * 获取指定时间之前N天的每一天时间（特别注意，会包含当前时间）
     * <p>
     * 如果今天是 '2017-01-02'，那么调用函数 {@code getDaysBeforeFromNow( 1 )} 将输出 [
     * Date('2017-01-02'), Date('2017-01-01') ]
     * </p>
     *
     * @param source
     *            指定的具体日期
     * @param howDays
     *            具体向前推多少天
     * @param isIncludingTarget
     *            是否包含指定日期
     * @return {@link java.util.Date} N天前的具体日期
     */
    public static final List<Date> getDaysBeforeList(Date source, int howDays, boolean isIncludingTarget) {

        List<Date> dates = new ArrayList<Date>();
        for (int i = (-howDays); (isIncludingTarget ? i <= 0 : i < 0); i++) {
            dates.add(getDaysBefore(source, i));
        }
        return dates;
    }

    /**
     * 获取当前时间之前N天的每一天时间（特别注意，会包含当前时间）
     * <p>
     * 如果今天是 '2017-01-02'，那么调用函数 {@code getDaysBeforeFromNow( 1 )} 将输出 [
     * String('2017-01-02'), String('2017-01-01') ]
     * </p>
     *
     * @param howDays
     *            具体向前推多少天
     * @param pattern
     *            时间格式化模板
     * @param isIncludingTarget
     *            是否包含指定日期
     * @return List&lt;String&gt; N天前的每一天日期
     */
    public static final List<String> getDaysBeforeListFromNowWithFormat(int howDays, String pattern,
                                                                        boolean isIncludingTarget) {
        return getDaysBeforeListWithFormat(new Date(), howDays, pattern, isIncludingTarget);
    }

    /**
     * 获取指定时间之前N天的每一天时间（特别注意，会包含当前时间）
     * <p>
     * 如果今天是 '2017-01-02'，那么调用函数 {@code getDaysBeforeFromNow( 1 )} 将输出 [
     * String('2017-01-02'), String('2017-01-01') ]
     * </p>
     *
     * @param source
     *            指定时间
     * @param howDays
     *            具体向前推多少天
     * @param pattern
     *            时间格式化模板
     * @param isIncludingTarget
     *            是否包含指定日期
     * @return List&lt;String&gt; N天前的每一天日期
     */
    public static final List<String> getDaysBeforeListWithFormat(Date source, int howDays, String pattern,
                                                                 boolean isIncludingTarget) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        List<String> dates = new ArrayList<String>();
        for (int i = (-howDays); (isIncludingTarget ? i <= 0 : i < 0); i++) {
            dates.add(dateFormat.format(getDaysBefore(source, i)));
        }
        return dates;
    }

    /**
     * 字符串HH:mm:ss
     */
    public static final String currentTimeStr() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
