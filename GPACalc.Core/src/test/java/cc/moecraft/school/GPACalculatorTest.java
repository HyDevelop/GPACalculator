package cc.moecraft.school;

import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.yaml.HyConfig;

import java.io.File;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class GPACalculatorTest
{
    public static void main(String[] args)
    {
        // Read grading profile
        HyConfig gradingConfig = new HyConfig(new File("./profiles/grading/ExampleHighSchoolWeighted.yml"));
        GradingProfile gradingProfile = GradingProfile.parseFromConfig(gradingConfig, "");

        // Read student profile
        HyConfig studentConfig = new HyConfig(new File("./profiles/student/Example.yml"));
        StudentProfile studentProfile = StudentProfile.parseFromConfig(studentConfig, "");

        // Create example grades (use my current grade.)
        Grades grades = new Grades()
                .putGrade("English 2 A", "A")
                .putGrade("Algebra 2 H", "A")
                .putGrade("Chemistry 1 H", "A-")
                .putGrade("Modern World History CP", "A+")
                .putGrade("Early Church CP", "A-")
                .putGrade("AP Computer Science A", "A");

        try
        {
            System.out.println("GPA: " + GPACalculator.calculate(gradingProfile, studentProfile, grades));
        }
        catch (NotFoundException e)
        {
            System.err.println("Not Found: " + e.getMessage());
        }
    }
}
