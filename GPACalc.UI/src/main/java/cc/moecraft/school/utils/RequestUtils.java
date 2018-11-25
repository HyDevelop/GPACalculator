package cc.moecraft.school.utils;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Boolean.*;

/**
 * 此类由 Hykilpikonna 在 2018/11/25 创建!
 * Created by Hykilpikonna on 2018/11/25!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class RequestUtils
{
    /**
     * Get param from header.
     *
     * @param request Request
     * @param key Header key
     * @param def Default value
     * @return Param, or default if it doesn't exist.
     */
    public static String getParam(HttpServletRequest request, String key, String def)
    {
        String value = request.getHeader(key);
        return value == null ? def : value;
    }

    /**
     * Get param from header.
     *
     * @param request Request
     * @param key Header key
     * @param def Default value
     * @return Param, or default if it doesn't exist.
     */
    public static boolean getParam(HttpServletRequest request, String key, boolean def)
    {
        return parseBoolean(getParam(request, key, def + ""));
    }
}
