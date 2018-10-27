package cc.moecraft.school.utils;

import com.google.gson.JsonSyntaxException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static cc.moecraft.school.Constants.GSON;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class JsonUtils
{
    /**
     * Parse an object from a json.
     *
     * @param json Json in string.
     * @param type Type.
     * @param <T> Object class.
     * @return Parsed object.
     */
    public static <T> T parseJson(String json, Class<T> type) throws JsonParsingException
    {
        if (json == null || json.isEmpty()) throw new JsonParsingException("Error: JSON Content is Empty.");

        try
        {
            T result = GSON.fromJson(json, type);

            if (result == null) throw new JsonParsingException("Error: Object is null.");
            return result;
        }
        catch (JsonSyntaxException e)
        {
            throw new JsonParsingException("Error: JSON Syntax Invalid.");
        }
    }

    /**
     * Object to Json String.
     *
     * @return JSON String.
     */
    public static String toJson(Object object)
    {
        return GSON.toJson(object);
    }

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
