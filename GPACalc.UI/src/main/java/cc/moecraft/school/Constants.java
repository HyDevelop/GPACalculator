package cc.moecraft.school;

import cc.moecraft.yaml.HyConfig;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;

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
    public static final File RUNTIME_CONFIG_FILE = new File("./runtime-config.yml");
    public static final HyConfig RUNTIME_CONFIG;

    public static final String GOOGLE_CLIENT_ID;
    public static final String JDBC_CONNECTION;

    public static final String USERNAME;
    public static final String PASSWORD;

    public static final String DEFAULT_STUDENT_PROFILE;
    public static final String DEFAULT_GRADING_PROFILE;

    static
    {
        RUNTIME_CONFIG = new HyConfig(RUNTIME_CONFIG_FILE);

        GOOGLE_CLIENT_ID = RUNTIME_CONFIG.getString("ClientID");
        JDBC_CONNECTION = RUNTIME_CONFIG.getString("Database.JDBConnection");
        USERNAME = RUNTIME_CONFIG.getString("Database.Username");
        PASSWORD = RUNTIME_CONFIG.getString("Database.Password");

        try
        {
            DEFAULT_GRADING_PROFILE = readFileToString(new File(RUNTIME_CONFIG.getString("DefaultProfile.Grading")), "utf-8");
            DEFAULT_STUDENT_PROFILE = readFileToString(new File(RUNTIME_CONFIG.getString("DefaultProfile.Student")), "utf-8");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
