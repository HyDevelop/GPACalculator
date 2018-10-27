package cc.moecraft.school.database;

import cc.moecraft.school.Constants;
import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.model.UserProfiles;
import cc.moecraft.school.database.service.Services;
import cc.moecraft.school.profile.student.StudentProfile;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import static cc.moecraft.school.Constants.*;
import static cc.moecraft.school.utils.JsonUtils.toJson;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class DatabaseUtils
{
    /**
     * Get user ID by google ID.
     *
     * @param idToken Google ID.
     * @return User ID.
     */
    public long getId(GoogleIdToken idToken)
    {
        UserInfo info = Services.userInfo.findByGoogleSub(idToken.getPayload().getSubject());

    /**
     * Register an user.
     *
     * @param googleSub Google sub ID.
     */
    public void register(String googleSub)
    {
        // TODO: Optimize this
        UserInfo info = new UserInfo();
        info.setGoogleSub(googleSub);
        info.save();

        UserProfiles profiles = new UserProfiles();
        profiles.setStudentProfile(toJson(DEFAULT_STUDENT_PROFILE));
        profiles.setGradingProfile(toJson(DEFAULT_GRADING_PROFILE));
        profiles.save();
    }
}
