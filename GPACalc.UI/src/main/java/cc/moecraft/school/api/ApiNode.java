package cc.moecraft.school.api;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public interface ApiNode
{
    public String nodeName();

    /**
     * Process an api request.
     *
     * @param request API request
     * @param token Google id token
     * @return Result.
     */
    public String process(HttpServletRequest request, GoogleIdToken token);
}
