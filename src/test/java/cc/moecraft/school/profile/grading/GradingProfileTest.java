package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfig;

import java.io.File;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class GradingProfileTest
{
    public static void main(String[] args)
    {
        HyConfig config = new HyConfig(new File("./profiles/grading/ExampleHighSchoolWeighted.yml"));
        GradingProfile exampleProfile = GradingProfile.parseFromConfig(config, "");

        System.out.println(exampleProfile.getGradeRangeList().getGradeRanges());
        System.out.println("\n\n\n" + exampleProfile);
    }
}
