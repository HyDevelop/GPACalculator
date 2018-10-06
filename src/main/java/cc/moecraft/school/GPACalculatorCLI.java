package cc.moecraft.school;

import cc.moecraft.school.profile.grading.CLGradeWeight;
import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.school.profile.student.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static cc.moecraft.school.utils.StringUtils.isDouble;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class GPACalculatorCLI
{
    /**
     * Launch a command line CLI.
     *
     * @param gradingProfile Grading profile
     * @param studentProfile Student profile
     */
    public static void launch(GradingProfile gradingProfile, StudentProfile studentProfile) throws IOException
    {
        // Console input.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Get grades input by user.
        Grades grades = new Grades();

        // Add previous gpa.
        while (true)
        {
            System.out.println("Do you have a previous GPA (y/n)?");
            String havePreviousGPA = reader.readLine();
            if (havePreviousGPA.equalsIgnoreCase("n")) break;
            if (havePreviousGPA.equalsIgnoreCase("y"))
            {
                System.out.println("Input your previous GPA: ");
                String previousGPA = reader.readLine();
                if (isDouble(previousGPA))
                {
                    error("Previous GPA must be a number.");
                    continue;
                }
                grades.setPreviousGPA(Double.parseDouble(previousGPA));
                break;
            }
            error("Error: Input must be y or n, %s is invalid.", havePreviousGPA);
        }

        // Loop through all subjects.
        for (Subject subject : studentProfile.getSubjectList().getSubjects())
        {
            while (true)
            {
                System.out.printf("What's your grade for %s (%s)? \n", subject.getKeyName(), subject.getName());
                String input = reader.readLine();
                String letterGrade = input;

                // It might be score instead of letter grade.
                if (isDouble(input))
                {
                    double value = Double.parseDouble(input);
                    if (value <= 0)
                    {
                        error("Score %s is not a valid score, it have to be > 0.", value);
                        continue;
                    }
                    letterGrade = gradingProfile.getGradeRangeList().searchByNumericGrade(value).getName();
                    if (letterGrade == null)
                    {
                        error("Error: Letter grade for %s not found.", value);
                        continue;
                    }
                }

                // It might not be valid.
                CLGradeWeight gradeWeight = gradingProfile.getCourseLevelList()
                        .searchByNameOrAlias(subject.getLevel()).getGradeWeights().searchByName(letterGrade);
                if (gradeWeight == null)
                {
                    error("Grade letter %s not found in level %s.", letterGrade, subject.getLevel());
                    continue;
                }

                grades.putGrade(subject.getName(), letterGrade);
                break;
            }
        }

        // Calculate
        try
        {
            System.out.println("GPA: " + GPACalculator.calculate(gradingProfile, studentProfile, grades));
        }
        catch (NotFoundException e)
        {
            System.err.println("Not Found: " + e.getMessage());
        }
    }

    private static void error(String format, Object ... args)
    {
        System.err.printf(format, args);
        try
        {
            Thread.sleep(5);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
