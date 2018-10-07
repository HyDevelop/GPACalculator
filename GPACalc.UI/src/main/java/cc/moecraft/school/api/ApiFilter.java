package cc.moecraft.school.api;

import cc.moecraft.school.exceptions.TokenException;
import cc.moecraft.school.utils.ExceptionUtils;
import cc.moecraft.school.utils.ResponseUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import jdk.nashorn.internal.parser.Token;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import static cc.moecraft.school.Constants.GOOGLE_CLIENT_ID;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class ApiFilter implements Filter
{
    private ApiNodeManager manager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        manager = new ApiNodeManager();

        manager.register(

        );

        System.out.println("API filter enabled!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equalsIgnoreCase("post") && request.getRequestURI().equalsIgnoreCase("/api"))
        {
            System.out.println("Requested Node: " + request.getHeader("node"));
            try
            {
                GoogleIdToken token = getToken(request);
            }
            catch (TokenException e)
            {
                ResponseUtils.writeResponse(response, e.getMessage());
            }
            return;
        }

        chain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy()
    {
        System.out.println("API filter disabled!");
    }

    /**
     * Get and verify google token.
     *
     * @param request Http request.
     * @return Token
     * @throws TokenException Token not specified, invalid, or something wrong happened.
     */
    public static GoogleIdToken getToken(HttpServletRequest request) throws TokenException
    {
        try
        {
            String googleToken = request.getHeader("token");
            if (googleToken == null) throw new TokenException("Token not found.");

            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
                    .Builder(new ApacheHttpTransport(), new JacksonFactory())
                    .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID)).build();

            GoogleIdToken idToken = verifier.verify(googleToken);
            if (idToken == null) throw new TokenException("Token invalid.");

            return idToken;
        }
        catch (GeneralSecurityException | IOException e)
        {
            throw new TokenException(ExceptionUtils.printStackTraceToString(e));
        }
    }
}
