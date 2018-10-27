package cc.moecraft.school.api.nodes.data.set;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.profile.grading.GradingProfile;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

import static cc.moecraft.school.database.DatabaseUtils.updateProfile;
import static cc.moecraft.school.utils.JsonUtils.JsonParsingException;
import static cc.moecraft.school.utils.JsonUtils.parseJson;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class NodeSetGradingProfile implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "data.set.grading-profile";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        try
        {
            GradingProfile gradingProfile = parseJson(content, GradingProfile.class);
            updateProfile(token.getPayload().getSubject(), gradingProfile);

            return "Success";
        }
        catch (JsonParsingException e)
        {
            return e.getMessage();
        }
    }
}
