package cc.moecraft.school.api;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ApiFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("API filter enabled!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equalsIgnoreCase("post") && request.getRequestURI().equalsIgnoreCase("/api"))
        {
            System.out.println("Requested Node: " + request.getHeader("node"));
            return;
        }

        chain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy()
    {
        System.out.println("API filter disabled!");
    }
}
