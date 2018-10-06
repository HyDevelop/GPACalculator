package cc.moecraft.school.profile.grading;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;

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
public class GradeRange implements Comparable<GradeRange>
{
    /**
     * Letter name of the grade.
     * Example: "A+"
     */
    private String name;

    /**
     * This value represents the minimum amount in the range.
     * For example, A+ would be 97 - 100, so put 97 as the value.
     */
    private double range;

    @Override
    public int compareTo(@Nonnull GradeRange other)
    {
        return (int) (other.range - this.range);
    }
}
