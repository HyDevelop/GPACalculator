package cc.moecraft.school;

import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.yaml.HyVirtualConfig;
import com.google.common.io.Resources;
import com.google.gson.Gson;

import java.io.IOException;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.io.Resources.getResource;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class Constants
{
    public static final Gson GSON;

    public static final HyVirtualConfig CONFIG;

    public static final String GOOGLE_CLIENT_ID;
    public static final String JDBC_CONNECTION;

    public static final String USERNAME;
    public static final String PASSWORD;

    public static final String DEFAULT_STUDENT_PROFILE_YML;
    public static final String DEFAULT_GRADING_PROFILE_YML;

    public static final StudentProfile DEFAULT_STUDENT_PROFILE;
    public static final GradingProfile DEFAULT_GRADING_PROFILE;

    static
    {
        try
        {
            GSON = new Gson();

            CONFIG = new HyVirtualConfig(Resources.toString(getResource("runtime-config.yml"), UTF_8));

            GOOGLE_CLIENT_ID = CONFIG.getString("ClientID");
            JDBC_CONNECTION = CONFIG.getString("Database.JDBConnection");
            USERNAME = CONFIG.getString("Database.Username");
            PASSWORD = CONFIG.getString("Database.Password");

            DEFAULT_GRADING_PROFILE_YML = Resources.toString(getResource(CONFIG.getString("DefaultProfile.Grading")), UTF_8);
            DEFAULT_STUDENT_PROFILE_YML = Resources.toString(getResource(CONFIG.getString("DefaultProfile.Student")), UTF_8);

            DEFAULT_STUDENT_PROFILE = StudentProfile.parseFromConfig(new HyVirtualConfig(DEFAULT_STUDENT_PROFILE_YML), "");
            DEFAULT_GRADING_PROFILE = GradingProfile.parseFromConfig(new HyVirtualConfig(DEFAULT_GRADING_PROFILE_YML), "");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
