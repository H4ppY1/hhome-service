package com.happy.hhome.util;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 非标日期工具类
 *
 * @author haopeng17313
 */
@Component
public class DateExUtils {

    /**
     * 按年
     */
    private static final int YEAR = 1;

    /**
     * 按月
     */
    private static final int MONTH = 2;

    /**
     * 按日
     */
    private static final int DAY = 3;

    /**
     * 整型日期按天增减
     * @param beginDate 开始日期
     * @param amount 增减数目
     * @return 结果日期（整型）
     * @throws ParseException 日期格式错误
     */
    public Integer addDays(Integer beginDate, Integer amount) {
        return add(beginDate, amount, DAY);
    }

    /**
     * 整型日期按月增减
     * @param beginDate 开始日期
     * @param amount 增减数目
     * @return 结果日期（整型）
     * @throws ParseException 日期格式错误
     */
    public Integer addMonths(Integer beginDate, Integer amount) {
        return add(beginDate, amount, MONTH);
    }

    /**
     * 整型日期按年增减
     * @param beginDate 开始日期
     * @param amount 增减数目
     * @return 结果日期（整型）
     * @throws ParseException 日期格式错误
     */
    public Integer addYears(Integer beginDate, Integer amount) {
        return add(beginDate, amount, YEAR);
    }

    /**
     * 整型日期增减
     * @param beginDate 开始日期
     * @param amount 增减数目
     * @param flag 标识
     * @return 结果日期（整型）
     * @throws ParseException 日期格式错误
     */
    private Integer add(Integer beginDate, Integer amount, Integer flag) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setLenient(false);
        String strDate = "0";
        try {
            Date date = date = simpleDateFormat.parse(beginDate.toString());
            Date newDate = null;

            switch (flag) {
                case YEAR :
                    newDate = DateUtils.addYears(date, amount);
                    break;
                case MONTH :
                    newDate = DateUtils.addMonths(date, amount);
                    break;
                case DAY :
                    newDate = DateUtils.addDays(date, amount);
                    break;
                default :
                    break;
            }
            strDate = simpleDateFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(strDate);
    }

    /**
     * 日期转换为整型
     * @param date 日期
     * @return 整型日期
     */
    public Integer dateToInteger(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setLenient(false);
        String strDate = simpleDateFormat.format(date);
        return Integer.valueOf(strDate);
    }

    /**
     * 整型转换为日期
     * @param integer 整型日期
     * @return 日期
     * @throws ParseException 日期格式错误
     */
    public Date integerToDate(Integer integer) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(integer.toString());
    }

    /**
     * 获取日期区间天数
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return 天数
     */
    public BigDecimal getDays(Integer beginDate, Integer endDate) {
        LocalDate segmentBeginDate = LocalDate.parse(beginDate.toString(), DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate segmentEndDate = LocalDate.parse(endDate.toString(), DateTimeFormatter.ofPattern("yyyyMMdd"));
        Long date = segmentBeginDate.until(segmentEndDate, ChronoUnit.DAYS) + 1;
        return new BigDecimal(String.valueOf(date));
    }

    /**
     * 字符串时间戳转换为8位整型日期
     * @param timeStamp 字符串时间戳
     * @return 8位整型日期
     */
    public Integer timeStampToInteger(String timeStamp) {
        Integer date = 0;
        if (null == timeStamp) {
            return date;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(timeStamp);
            String dateStr = timeStamp.split(" ")[0].replace("-", "");
            date = Integer.valueOf(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
