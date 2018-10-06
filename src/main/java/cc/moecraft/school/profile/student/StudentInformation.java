package cc.moecraft.school.profile.student;

import cc.moecraft.yaml.HyConfig;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@AllArgsConstructor @Data
public class StudentInformation
{
    /**
     * Student name
     */
    private String name;

    /**
     * Grade level. (eg. Junior = 11)
     */
    private int grade;

    /**
     * Semester (1 or 2)
     */
    private int semester;

    public static StudentInformation parseFromConfig(HyConfig config, String parentPath)
    {
        return new StudentInformation(
                config.getString(parentPath + ".Name"),
                config.getInt(parentPath + ".Grade"),
                config.getInt(parentPath + ".Semester")
        );
    }
}
