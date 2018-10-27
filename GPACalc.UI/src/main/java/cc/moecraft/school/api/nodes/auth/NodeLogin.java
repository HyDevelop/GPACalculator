package cc.moecraft.school.api.nodes.auth;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.DatabaseUtils;
import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.service.Services;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class NodeLogin implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "auth.login";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        String subId = token.getPayload().getSubject();
        UserInfo info = Services.userInfo.findByGoogleSub(subId);

        if (info != null) return "Logged in";

        DatabaseUtils.register(subId);
        return "Registered";
    }
}
