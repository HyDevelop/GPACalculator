package cc.moecraft.school;

import cc.moecraft.yaml.HyConfig;

import java.io.File;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
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

    static
    {
        RUNTIME_CONFIG = new HyConfig(RUNTIME_CONFIG_FILE);

        GOOGLE_CLIENT_ID = RUNTIME_CONFIG.getString("ClientID");
        JDBC_CONNECTION = RUNTIME_CONFIG.getString("Database.JDBConnection");
        USERNAME = RUNTIME_CONFIG.getString("Database.Username");
        PASSWORD = RUNTIME_CONFIG.getString("Database.Password");
    }
}
