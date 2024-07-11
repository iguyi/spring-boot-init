package com.guyi.project.common.util;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串校验
 *
 * @author 孤诣
 */
public class StringCheckUtil {
    /**
     * 校验字符串格式是否【符合】正则表达式
     *
     * @param str   需要校验的字符串
     * @param regex 字符串校验规则
     * @return 如果返回值为 true, 表示字符串【符合】规则
     */
    public static boolean isRegex(@NotNull String str, @NotNull String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    /**
     * 校验字符串格式是否【不符合】正则表达式
     *
     * @param str   需要校验的字符串
     * @param regex 字符串校验规则
     * @return 如果返回值为 true, 表示字符串【不符合】规则
     */
    public static boolean notIsRegex(@NotNull String str, @NotNull String regex) {
        return !isRegex(str, regex);
    }

    /**
     * 判断字符串长度是否在 [minLength, maxLength] 内
     *
     * @return 如果返回 true, 说明字符串长度在 [minLength, maxLength] 内
     */
    public static boolean lengthValid(@NotNull String str, int minLength, int maxLength) {
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }

    /**
     * 判断字符串长度是否在 [minLength, maxLength] 之外
     *
     * @return 如果返回 true, 说明字符串长度在 [minLength, maxLength] 之外
     */
    public static boolean lengthNotValid(@NotNull String str, int minLength, int maxLength) {
        return !lengthValid(str, minLength, maxLength);
    }
}
