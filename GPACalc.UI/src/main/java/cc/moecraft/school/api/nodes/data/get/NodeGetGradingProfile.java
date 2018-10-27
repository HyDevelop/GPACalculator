package cc.moecraft.school.api.nodes.data.get;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.service.Services;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

import static cc.moecraft.school.Constants.GSON;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class NodeGetGradingProfile implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "data.get.grading-profile";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        GoogleIdToken.Payload id = token.getPayload();
        UserInfo profiles = Services.userInfo.findByGoogleSub(id.getSubject());

        if (profiles == null) return "Error: User not registered.";
        return GSON.toJson(profiles.getGradingProfile());
    }
}
