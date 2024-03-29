package cc.moecraft.school.utils;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ResponseUtils
{
    /**
     * Write content to a http response.
     *
     * @param response Response.
     * @param content Content.
     */
    public static void writeResponse(ServletResponse response, String content)
    {
        CustomResponseWrapper responseWrapper = new CustomResponseWrapper((HttpServletResponse) response);
        PrintWriter writer = responseWrapper.getWriter();

        if (writer != null)
        {
            try
            {
                response.getWriter().write(content);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static class CustomResponseWrapper extends HttpServletResponseWrapper
    {
        private CharArrayWriter output;

        public CustomResponseWrapper(HttpServletResponse response)
        {
            super(response);
            output = new CharArrayWriter();
        }

        public String getResponseContent()
        {
            return output.toString();
        }

        public PrintWriter getWriter()
        {
            return new PrintWriter(output);
        }
    }
}
