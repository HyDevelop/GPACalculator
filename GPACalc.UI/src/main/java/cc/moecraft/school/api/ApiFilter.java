package cc.moecraft.school.api;

import cc.moecraft.school.api.nodes.auth.NodeLogin;
import cc.moecraft.school.api.nodes.data.get.NodeGetGradingProfile;
import cc.moecraft.school.api.nodes.data.get.NodeGetStudentProfile;
import cc.moecraft.school.api.nodes.misc.NodeTest;
import cc.moecraft.school.exceptions.TokenException;
import cc.moecraft.school.utils.ExceptionUtils;
import cc.moecraft.school.utils.ResponseUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.stream.Collectors;

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
                new NodeLogin(),
                new NodeTest(),
                new NodeGetStudentProfile(),
                new NodeGetGradingProfile()
        );

        System.out.println("API filter enabled!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equalsIgnoreCase("post") && request.getRequestURI().equalsIgnoreCase("/api"))
        {
            try
            {
                // Verify node. Even though it's not a token exception, but it does the same thing.
                String nodeName = request.getHeader("node");
                if (nodeName == null) throw new TokenException("Node not specified.");

                // Find node.
                ApiNode node = manager.getNode(nodeName);
                if (node == null) throw new TokenException("Node " + nodeName + " is not a valid api node.");

                // Verify token.
                GoogleIdToken token = getToken(request);

                // Obtain Content.
                String content = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

                // TODO: Remove debug output
                System.out.println("Request received: " + node + " : " + content);

                // Write response.
                ResponseUtils.writeResponse(response, node.process(request, token, content));
            }
            catch (TokenException e)
            {
                // Write error.
                ResponseUtils.writeResponse(response, "Error: Token Invalid: " + e.getMessage());
            }
            catch (Throwable e)
            {
                // Write error.
                ResponseUtils.writeResponse(response, "Error: Unpredicted Error: " + e.getMessage());
            }
        }
        else chain.doFilter(servletRequest, response);
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
