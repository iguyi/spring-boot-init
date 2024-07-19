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
     * 匹配自然数的正则表达式
     */
    public static final String NUMBER_REGEX = "^-?\\d+$";

    /**
     * 匹配只包含字母的字符串的正则表达式
     */
    public static final String LETTER_REGEX = "^[a-zA-Z]+$";

    /**
     * 匹配只包含数字、字母、下划线的字符串的正则表达式
     */
    public static final String LETTER_NUMBER_REGEX = "^[0-9a-zA-Z_]+$";

    /**
     * 匹配合法密码的字符串的正则表达式 <br/>
     * 可以包含: 数字、字母、`~·!@$%^&*()_-+=[]{}|\:;"'><,.?/
     */
    public static final String PASSWORD_REGEX = "^[0-9a-zA-Z!@#$%^&*()\\-_=+|\\\\:;\\\"'<>,~·`.?/\\{\\[\\}\\]]+$";

    /**
     * 邮箱地址校验
     */
    public static final String EMAIL_REGEX = "^[0-9a-zA-Z_-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * 匹配只包含空白字符的字符串的正则表达式, 空白字符如下: <br/>
     * - 空格 <br/>
     * - 制表符 <br/>
     * - 换行符 <br/>
     * - 其他不可见字符
     */
    public static final String BLANK_REGEX = "^\\s+$";

    /**
     * 校验字符串格式是否【符合】正则表达式
     *
     * @param str   需要校验的字符串
     * @param regex 字符串校验规则
     * @return 如果返回值为 true, 表示字符串【符合】规则
     */
    public static boolean isMatch(@NotNull String str, @NotNull String regex) {
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
    public static boolean notMatch(@NotNull String str, @NotNull String regex) {
        return !isMatch(str, regex);
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

    /**
     * 判断字符串是否只包含空白字符, 空白字符如下: <br/>
     * - null
     * - 空格 <br/>
     * - 制表符 <br/>
     * - 换行符 <br/>
     * - 其他不可见字符
     */
    public static boolean isBlank(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return isMatch(str, BLANK_REGEX);
    }
}
