package com.example.demo.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static com.example.demo.util.StringUtils.isBlank;


public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException("工具类禁止实例化");
    }

    // ---------------------- 格式与解析 ----------------------

    /**
     * 默认日期时间格式（yyyy-MM-dd HH:mm:ss）
     */
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);

    /**
     * 格式化日期时间（LocalDateTime -> String）
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    public static String format(LocalDateTime dateTime) {
        return format(dateTime, DEFAULT_DATETIME_PATTERN);
    }

    /**
     * 解析字符串为日期时间（String -> LocalDateTime）
     */
    public static LocalDateTime parse(String dateTimeStr, String pattern) {
        if (isBlank(dateTimeStr)) return null;
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parse(String dateTimeStr) {
        return parse(dateTimeStr, DEFAULT_DATETIME_PATTERN);
    }

    // ---------------------- 日期计算 ----------------------

    /**
     * 日期加减天数
     */
    public static LocalDateTime addDays(LocalDateTime dateTime, int days) {
        return dateTime != null ? dateTime.plusDays(days) : null;
    }

    /**
     * 计算两个日期之间的天数差（end - start）
     */
    public static long daysBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return Duration.between(start, end).toDays();
    }

    // ---------------------- 常用日期获取 ----------------------

    /**
     * 获取当天的开始时间（00:00:00）
     */
    public static LocalDateTime getStartOfDay(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.toLocalDate().atStartOfDay() : null;
    }

    /**
     * 获取当月的最后一天
     */
    public static LocalDateTime getLastDayOfMonth(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.with(TemporalAdjusters.lastDayOfMonth()) : null;
    }

    // ---------------------- 兼容旧版 Date ----------------------

    /**
     * 转换 Date 到 LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

    /**
     * 转换 LocalDateTime 到 Date
     */
    public static Date toDate(LocalDateTime dateTime) {
        return dateTime != null ?
                Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    // ---------------------- 时区转换 ----------------------

    /**
     * 转换到指定时区的日期时间
     * @param sourceTime 原时间
     * @param sourceZone 原时区（如 "UTC+8"）
     * @param targetZone 目标时区（如 "America/New_York"）
     */
    public static LocalDateTime convertZone(LocalDateTime sourceTime, String sourceZone, String targetZone) {
        if (sourceTime == null) return null;
        return sourceTime.atZone(ZoneId.of(sourceZone))
                .withZoneSameInstant(ZoneId.of(targetZone))
                .toLocalDateTime();
    }
}
