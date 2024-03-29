package cc.moecraft.school.database;

import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.service.Services;
import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;

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
     * @param googleSub Google sub ID
     * @param profile Student Profile.
     */
    public static void updateProfile(String googleSub, StudentProfile profile)
    {
        UserInfo info = Services.userInfo.findByGoogleSub(googleSub);

        info.setStudentProfile(toJson(profile));
        info.update();
    }

    /**
     * Update a grading profile.
     *
     * @param googleSub Google sub ID
     * @param profile Grading Profile.
     */
    public static void updateProfile(String googleSub, GradingProfile profile)
    {
        UserInfo info = Services.userInfo.findByGoogleSub(googleSub);

        info.setGradingProfile(toJson(profile));
        info.update();
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
