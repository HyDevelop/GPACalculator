package cc.moecraft.school.profile.grading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

/**
 * 此类由 Hykilpikonna 在 2018/10/04 创建!
 * Created by Hykilpikonna on 2018/10/04!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CourseLevel
{
    /**
     * Name of it.
     * For example, "Honors"
     */
    @NonNull
    private String name;

    /**
     * How many points you get for A+.
     * For example, Honors = 4.75 (at least in my school...);
     */
    @NonNull
    private double maxPoints;

    /**
     * Other names for it.
     * This exists because sometimes teachers just abbreviate "Honors" with "H"...
     * So inconsistent...
     */
    private ArrayList<String> alias;
}
