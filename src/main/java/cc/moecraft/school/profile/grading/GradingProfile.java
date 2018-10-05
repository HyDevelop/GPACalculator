package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfig;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@Data
public class GradingProfile
{
    private CourseLevelList courseLevelList;
    private double gradeDecreaseBy;

    /**
     * Parse a grading profile object from a grading profile config.
     *
     * @param config Grading profile.
     * @param parentPath Parent path to the grading profile. This should be "".
     * @return Parsed object.
     */
    public static GradingProfile parseFromConfig(HyConfig config, String parentPath)
    {
        GradingProfile result = new GradingProfile();

        result.setCourseLevelList(CourseLevelList.parseFromConfig(config, parentPath + ".Levels"));
        result.setGradeDecreaseBy(config.getDouble("Grades.DecreaseBy"));

        return result;
    }
}
