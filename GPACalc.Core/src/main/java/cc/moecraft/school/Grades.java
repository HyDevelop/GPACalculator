package cc.moecraft.school;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@Data
public class Grades
{
    /**
     * Previous GPA
     */
    private Double previousGPA;

    /**
     * Subject to grade.
     * e.g. "English 2 A", "A-"
     */
    private final Map<String, String> subjectGradeMap = new HashMap<>();

    /**
     * Put a grade in the map
     *
     * @param subject Subject name
     * @param grade Grade letter
     * @return This object
     */
    public Grades putGrade(String subject, String grade)
    {
        subjectGradeMap.put(subject, grade);
        return this;
    }
}
