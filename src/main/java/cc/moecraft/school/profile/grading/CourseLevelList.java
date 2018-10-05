package cc.moecraft.school.profile.grading;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@Getter @ToString
public class CourseLevelList
{
    private final ArrayList<CourseLevel> levels = new ArrayList<>();

    /**
     * Put a course level in the list.
     *
     * @param level Level.
     */
    public void put(CourseLevel level)
    {
        levels.add(level);
    }
}
