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
