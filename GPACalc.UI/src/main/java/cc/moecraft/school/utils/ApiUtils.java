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
            T result = new Gson().fromJson(json, type);

            if (result == null) throw new JsonParsingException("Error: Object is null.");
            return result;
        }
        catch (JsonSyntaxException e)
        {
            throw new JsonParsingException("Error: JSON Syntax Invalid.");
        }
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
