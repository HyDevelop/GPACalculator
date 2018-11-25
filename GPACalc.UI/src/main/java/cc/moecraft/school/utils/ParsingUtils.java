package cc.moecraft.school.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 此类由 Hykilpikonna 在 2018/11/25 创建!
 * Created by Hykilpikonna on 2018/11/25!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ParsingUtils
{
    /**
     * A list of string value that are considered true.
     */
    public static final List<String> trueList = Arrays.asList(
            "true", "yes", "on", "1",
            "yup", "ya", "yeah", "aye", "uh-huh", "right",
            "affirmative", "by all means", "sure", "totally",
            "是", "启用", "はい"
    );

    /**
     * Parse a boolean from string.
     *
     * @param value String value
     * @return Boolean value
     */
    public static boolean parseBoolean(String value)
    {
        return trueList.contains(value.toLowerCase());
    }
}
