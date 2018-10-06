package cc.moecraft.school.profile.grading;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@Getter @ToString
public class GradeRangeList
{
    private final ArrayList<GradeRange> gradeRanges = new ArrayList<>();

    /**
     * Put a grade range in the list.
     *
     * @param gradeRange Grade range.
     */
    public void put(GradeRange gradeRange)
    {
        gradeRanges.add(gradeRange);
    }
}
