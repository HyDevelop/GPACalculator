package cc.moecraft.school;

import cc.moecraft.school.profile.grading.CLGradeWeight;
import cc.moecraft.school.profile.grading.CourseLevel;
import cc.moecraft.school.profile.grading.GradingProfile;
import cc.moecraft.school.profile.student.StudentProfile;
import cc.moecraft.school.profile.student.Subject;

import java.util.ArrayList;
import java.util.Map;

import static cc.moecraft.school.Messages.*;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class GPACalculator
{
    /**
     * Calculate the GPA based on a grading profile, a student profile, and the current grades.
     *
     * @param gradingProfile Grading profile
     * @param studentProfile Student profile
     * @param grades Current grades.
     * @return Current GPA.
     */
    public static double calculate(GradingProfile gradingProfile, StudentProfile studentProfile, Grades grades)
            throws NotFoundException
    {
        // Record all the grade points first, then calculate average at the end.
        double gradePointTotal = 0;
        double divider = 0;

        // Add other grades.
        for (Map.Entry<String, String> entry : grades.getSubjectGradeMap().entrySet())
        {
            String subjectName = entry.getKey();
            String letterGrade = entry.getValue();

            Subject subject = studentProfile.getSubjectList().searchByName(subjectName);
            notNull(subject, SUBJECT_NOT_FOUND, subjectName);

            CourseLevel courseLevel = gradingProfile.getCourseLevelList().searchByNameOrAlias(subject.getLevel());
            notNull(courseLevel, LEVEL_NOT_FOUND,  subject.getLevel());

            CLGradeWeight gradeWeight = courseLevel.getGradeWeights().searchByName(letterGrade);
            notNull(gradeWeight, LETTER_GRADE_NOT_FOUND, letterGrade);

            // According to http://www.back2college.com/gpa.htm
            // GPA = Total Grade Points / Total Credit Hours Attempted.
            // Grade Points for each course = Grade Points for letter * Credit Hours.
            gradePointTotal += gradeWeight.getCredit() * subject.getCredits();
            divider += subject.getCredits();
        }

        // Calculate average.
        double gradePointAverage = gradePointTotal / divider;

        // Add in the previous gpa.
        if (grades.getPreviousGPA() != null)
        {
            gradePointAverage += grades.getPreviousGPA();
            gradePointAverage /= 2d;
        }

        // Return result.
        return gradePointAverage;
    }

    /**
     * Verify if a object is null or not. Throw exception if it is.
     *
     * @param object Object to verify
     * @param f Format of the message
     * @param args Message arguments
     * @throws NotFoundException Is null
     */
    private static void notNull(Object object, String f, Object ... args) throws NotFoundException
    {
        if (object == null) throw new NotFoundException(String.format(f, args));
    }
}
