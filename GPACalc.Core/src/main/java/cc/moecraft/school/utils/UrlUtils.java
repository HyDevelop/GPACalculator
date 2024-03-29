package cc.moecraft.school.utils;

import java.util.Map;

import static cc.moecraft.utils.MapBuilder.build;
import static cn.hutool.http.HttpUtil.urlWithForm;

/**
 * 此类由 Hykilpikonna 在 2018/11/11 创建!
 * Created by Hykilpikonna on 2018/11/11!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class UrlUtils
{
    /**
     * Make URL
     *
     * @param url Base URL
     * @param params Parameter key value pair
     * @return Complete url.
     */
    public static String makeUrl(String url, Map<String, Object> params)
    {
        return urlWithForm(url, params, null, false);
    }

    /**
     * Make URL
     *
     * @param url Base URL
     * @param p Parameter key value pair
     * @return Complete url.
     */
    public static String makeUrl(String url, Object ... p)
    {
        return makeUrl(url, build(String.class, Object.class, p));
    }
}
