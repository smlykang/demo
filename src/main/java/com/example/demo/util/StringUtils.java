package com.example.demo.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 字符串操作工具类
 */
public class StringUtils {
    private StringUtils() {
        throw new UnsupportedOperationException("工具类禁止实例化");
    }

    // ---------------------- 判空与校验 ----------------------

    /**
     * 判断字符串是否为空（null 或长度为0）
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否为非空
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空白（null、空字符串或仅包含空白字符）
     */
    public static boolean isBlank(CharSequence str) {
        if (isEmpty(str)) return true;
        return str.chars().allMatch(Character::isWhitespace);
    }

    /**
     * 判断字符串是否为非空白
     */
    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    // ---------------------- 截取与格式化 ----------------------

    /**
     * 截取字符串，避免越界
     * @param str 原始字符串
     * @param start 起始位置（包含）
     * @param end 结束位置（不包含）
     */
    public static String substringSafe(String str, int start, int end) {
        if (isEmpty(str)) return "";
        int len = str.length();
        start = Math.max(start, 0);
        end = Math.min(end, len);
        return start < end ? str.substring(start, end) : "";
    }

    /**
     * 格式化字符串（类似 Slf4j 的 {} 占位符）
     * 示例：format("Name: {}, Age: {}", "Alice", 30) -> "Name: Alice, Age: 30"
     */
    public static String format(String template, Object... args) {
        if (isEmpty(template) || args == null || args.length == 0) {
            return template;
        }
        StringBuilder sb = new StringBuilder();
        int argIndex = 0;
        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            if (c == '{' && i + 1 < template.length() && template.charAt(i + 1) == '}') {
                if (argIndex < args.length) {
                    sb.append(args[argIndex++]);
                    i++; // 跳过下一个字符 '}'
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // ---------------------- 转换与脱敏 ----------------------

    /**
     * 驼峰命名转下划线命名（如 "userName" -> "USER_NAME"）
     */
    public static String camelToSnakeCase(String str) {
        if (isBlank(str)) return str;
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();
    }

    /**
     * 手机号脱敏（保留前3位和后4位）
     * 示例：脱敏("13812345678") -> "138****5678"
     */
    public static String maskMobile(String mobile) {
        if (isBlank(mobile) || mobile.length() < 7) return mobile;
        return substringSafe(mobile, 0, 3) + "****" + substringSafe(mobile, mobile.length() - 4, mobile.length());
    }

    // ---------------------- 生成与拼接 ----------------------

    /**
     * 生成指定长度的随机字符串（包含字母和数字）
     */
    public static String generateRandomAlphanumeric(int length) {
        if (length <= 0) return "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        return IntStream.range(0, length)
                .map(i -> chars.charAt(random.nextInt(chars.length())))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * 拼接多个对象为字符串（自动跳过null值）
     */
    public static String join(Object... parts) {
        if (parts == null || parts.length == 0) return "";
        return Arrays.stream(parts).map(part -> part != null ? part.toString() : "")
                .collect(Collectors.joining());
    }
}
