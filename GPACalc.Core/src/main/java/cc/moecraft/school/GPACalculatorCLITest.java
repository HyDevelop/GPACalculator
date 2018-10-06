package cc.moecraft.school;

import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.yaml.HyConfig;

import java.io.File;
import java.io.IOException;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class GPACalculatorCLITest
{
    public static void main(String[] args) throws IOException
    {
        // Read grading profile
        HyConfig gradingConfig = new HyConfig(new File("./profiles/grading/ExampleHighSchoolWeighted.yml"));
        GradingProfile gradingProfile = GradingProfile.parseFromConfig(gradingConfig, "");

        // Read student profile
        HyConfig studentConfig = new HyConfig(new File("./profiles/student/Example.yml"));
        StudentProfile studentProfile = StudentProfile.parseFromConfig(studentConfig, "");

        GPACalculatorCLI.launch(gradingProfile, studentProfile);
    }
}
