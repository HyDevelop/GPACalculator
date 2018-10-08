package cc.moecraft.school.api.nodes.data;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.model.UserProfiles;
import cc.moecraft.school.profile.student.StudentProfile;
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
public class NodeStudentProfile implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "data.student-profile";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token)
    {
        GoogleIdToken.Payload id = token.getPayload();

        UserProfiles profiles = UserProfiles.service().findById(id.getSubject());
        if (profiles == null) return "Error: User not registered.";

        StudentProfile studentProfile = StudentProfile.parseFromConfig(new HyVirtualConfig(profiles.getStudentProfile()), "");
        return new Gson().toJson(studentProfile);
    }
}
