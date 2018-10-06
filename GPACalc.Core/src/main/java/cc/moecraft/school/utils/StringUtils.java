package cc.moecraft.school.utils;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class StringUtils
{
    public static boolean isInt(String string)
    {
        try
        {
            int x = parseInt(string);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isDouble(String string)
    {
        try
        {
            double x = parseDouble(string);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
