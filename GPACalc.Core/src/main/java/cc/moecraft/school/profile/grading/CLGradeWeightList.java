package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfigBase;
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
public class CLGradeWeightList
{
    private final ArrayList<CLGradeWeight> gradeWeights = new ArrayList<>();

    /**
     * Put a grade weight in the list.
     *
     * @param gradeRange Grade weight.
     */
    public void put(CLGradeWeight gradeRange)
    {
        gradeWeights.add(gradeRange);
    }

    /**
     * Search for a grade weight by name.
     *
     * @param letter Name of the grade letter, e.g. "A+"
     * @return The grade weight. Returns null if not found.
     */
    public CLGradeWeight searchByName(String letter)
    {
        for (CLGradeWeight gradeWeight : gradeWeights) if (gradeWeight.getName().equalsIgnoreCase(letter)) return gradeWeight;
        return null;
    }

    /**
     * Parse a grade weight list object from a grading profile config.
     *
     * @param config Grading profile.
     * @param parentPath Parent path to the grade weights section.
     * @return Parsed object.
     */
    public static CLGradeWeightList parseFromConfig(HyConfigBase config, String parentPath)
    {
        CLGradeWeightList result = new CLGradeWeightList();

        for (String key : config.getKeys(parentPath))
        {
            String entry = parentPath + "." + key;
            double value = config.getDouble(entry);

            result.put(new CLGradeWeight(key, value));
        }

        return result;
    }
}
