package cc.moecraft.school.database;

import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.service.Services;
import cc.moecraft.school.profile.student.StudentProfile;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import static cc.moecraft.school.Constants.DEFAULT_GRADING_PROFILE;
import static cc.moecraft.school.Constants.DEFAULT_STUDENT_PROFILE;
import static cc.moecraft.school.utils.JsonUtils.toJson;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class DatabaseUtils
{
    /**
     * Get user info by google ID.
     *
     * @param googleSub Google sub ID.
     * @return User Info.
     */
    public static UserInfo getInfoOrRegister(String googleSub)
    {
        UserInfo info = Services.userInfo.findByGoogleSub(googleSub);

        if (info == null)
        {
            register(googleSub);
            return getInfoOrRegister(googleSub);
        }

        return info;
    }

    /**
     * Update a student profile.
     *
     * @param idToken Google ID
     * @param profile Student Profile.
     */
    public static void updateProfile(GoogleIdToken idToken, StudentProfile profile)
    {

    }

    /**
     * Register an user.
     *
     * @param googleSub Google sub ID.
     */
    public static void register(String googleSub)
    {
        UserInfo existingInfo = Services.userInfo.findByGoogleSub(googleSub);
        if (existingInfo != null) return;

        UserInfo info = new UserInfo();
        info.setGoogleSub(googleSub);
        info.setStudentProfile(toJson(DEFAULT_STUDENT_PROFILE));
        info.setGradingProfile(toJson(DEFAULT_GRADING_PROFILE));
        info.save();
    }
}
