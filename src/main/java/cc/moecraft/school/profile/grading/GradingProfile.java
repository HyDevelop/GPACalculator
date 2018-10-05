package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfig;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@Data
public class GradingProfile
{
    private CourseLevelList courseLevelList;
    private double gradeDecreaseBy;
}
