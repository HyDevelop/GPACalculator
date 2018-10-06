package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfig;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
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

    /**
     * Search for a grade range by name.
     *
     * @param letter Name of the grade letter, e.g. "A+"
     * @return The grade range. Returns null if not found.
     */
    public GradeRange searchByName(String letter)
    {
        for (GradeRange gradeRange : gradeRanges) if (gradeRange.getName().equalsIgnoreCase(letter)) return gradeRange;
        return null;
    }

    /**
     * Parse a grade range list object from a grading profile config.
     *
     * @param config Grading profile.
     * @param parentPath Parent path to the grade ranges section.
     * @return Parsed object.
     */
    public static GradeRangeList parseFromConfig(HyConfig config, String parentPath)
    {
        GradeRangeList result = new GradeRangeList();

        for (String key : config.getKeys(parentPath))
        {
            String entry = parentPath + "." + key;
            double value = config.getDouble(entry);

            result.put(new GradeRange(key, value));
        }

        return result;
    }
}
