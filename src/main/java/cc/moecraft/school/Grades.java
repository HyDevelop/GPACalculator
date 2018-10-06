package cc.moecraft.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
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
     */
    public void putGrade(String subject, String grade)
    {
        subjectGradeMap.put(subject, grade);
    }
}
