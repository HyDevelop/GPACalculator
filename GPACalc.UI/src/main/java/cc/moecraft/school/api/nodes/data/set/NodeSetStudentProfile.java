package cc.moecraft.school.api.nodes.data.set;

import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.profile.student.StudentProfile;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

import static cc.moecraft.school.database.DatabaseUtils.updateProfile;
import static cc.moecraft.school.utils.JsonUtils.JsonParsingException;
import static cc.moecraft.school.utils.JsonUtils.parseJson;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class NodeSetStudentProfile implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "data.set.student-profile";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        try
        {
            StudentProfile studentProfile = parseJson(content, StudentProfile.class);
            updateProfile(token.getPayload().getSubject(), studentProfile);

            return "Success";
        }
        catch (JsonParsingException e)
        {
            return e.getMessage();
        }
    }
}
