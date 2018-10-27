package cc.moecraft.school.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ApiUtils
{
    /**
     * Exception that it throws.
     */
    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor @Data
    public static class JsonParsingException extends Exception
    {
        public final String message;
    }
}
