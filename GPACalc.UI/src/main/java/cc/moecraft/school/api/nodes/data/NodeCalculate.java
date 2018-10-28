package cc.moecraft.school.api.nodes.data;

import cc.moecraft.school.GPACalculator;
import cc.moecraft.school.Grades;
import cc.moecraft.school.NotFoundException;
import cc.moecraft.school.api.ApiNode;
import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.service.Services;
import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.school.utils.JsonUtils;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.http.HttpServletRequest;

import static cc.moecraft.school.utils.JsonUtils.parseJson;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class NodeCalculate implements ApiNode
{
    @Override
    public String nodeName()
    {
        return "data.calculate";
    }

    @Override
    public String process(HttpServletRequest request, GoogleIdToken token, String content)
    {
        try
        {
            UserInfo info = Services.userInfo.findByGoogleSub(token.getPayload().getSubject());

            if (info == null) return "Error: Not registered.";

            Grades grades = parseJson(content, Grades.class);
            GradingProfile gradingProfile = info.getGradingProfileObject();
            StudentProfile studentProfile = info.getStudentProfileObject();

            return String.valueOf(GPACalculator.calculate(gradingProfile, studentProfile, grades));
        }
        catch (JsonUtils.JsonParsingException e)
        {
            return e.getMessage();
        }
        catch (NotFoundException e)
        {
            return "Error: Not Found: " + e.getMessage();
        }
    }
}
