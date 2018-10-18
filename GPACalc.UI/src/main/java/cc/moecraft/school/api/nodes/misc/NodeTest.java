package cc.moecraft.school.api.nodes.misc;

import cc.moecraft.school.api.ApiNode;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class NodeTest implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "misc.test";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        return "Success! " + token + "\n - Content: " + content;
    }
}
