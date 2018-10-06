package cc.moecraft.school.profile.grading;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@AllArgsConstructor
@Data
public class CLGradeWeight
{
    /**
     * Letter name of the grade.
     * Example: "A+"
     */
    private String name;

    /**
     * The amount of points you get for this grade.
     * For example, "A+" = 5.0, "A" = 4.75
     */
    private double credit;
}
