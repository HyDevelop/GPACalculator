package cc.moecraft.school.api.nodes.auth;

import cc.moecraft.school.Constants;
import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.model.UserProfiles;
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
        GoogleIdToken.Payload id = token.getPayload();

        UserProfiles profiles = UserProfiles.service().findById(id.getSubject());
        if (profiles == null)
        {
            // Register
            profiles = new UserProfiles();
            profiles.setGoogleSub(id.getSubject());
            profiles.setStudentProfile(Constants.DEFAULT_STUDENT_PROFILE);
            profiles.setGradingProfile(Constants.DEFAULT_GRADING_PROFILE);
            profiles.save();
            return "Registered";
        }

        return "Logged in";
    }
}
