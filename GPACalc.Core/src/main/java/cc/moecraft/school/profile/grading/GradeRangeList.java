package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfigBase;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(gradeRanges);
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
    public static GradeRangeList parseFromConfig(HyConfigBase config, String parentPath)
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

    /**
     * Search for letter grade by numeric grade.
     *
     * @param grade Numeric grade
     * @return Grade range object
     */
    public GradeRange searchByNumericGrade(double grade)
    {
        for (GradeRange gradeRange : gradeRanges)
        {
            if (grade > gradeRange.getRange()) return gradeRange;
        }
        throw new RuntimeException("Failed to get grade range.");
    }
}
