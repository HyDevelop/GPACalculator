package cc.moecraft.school.api.nodes.data.get;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.model.UserProfiles;
import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.yaml.HyVirtualConfig;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class NodeGradingProfile implements ApiNode
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

        UserProfiles profiles = UserProfiles.service().findById(id.getSubject());
        if (profiles == null) return "Error: User not registered.";

        GradingProfile gradingProfile = GradingProfile.parseFromConfig(new HyVirtualConfig(profiles.getGradingProfile()), "");
        return new Gson().toJson(gradingProfile);
    }
}
