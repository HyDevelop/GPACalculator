package cc.moecraft.school.profile.grading;

import cc.moecraft.yaml.HyConfigBase;
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
    public CourseLevelList put(CourseLevel level)
    {
        levels.add(level);
        return this;
    }

    /**
     * Search for a course level by name.
     *
     * @param name Name of the level, e.g. "Honors."
     * @return The course level. Returns null if not found.
     */
    public CourseLevel searchByName(String name)
    {
        for (CourseLevel level : levels) if (level.getName().equalsIgnoreCase(name)) return level;
        return null;
    }

    /**
     * Search for a course level by name or alias.
     *
     * @param nameOrAlias Name or alias of the level, e.g. "Honors." or "H"
     * @return The course level. Returns null if not found.
     */
    public CourseLevel searchByNameOrAlias(String nameOrAlias)
    {
        for (CourseLevel level : levels)
        {
            if (level.getName().equalsIgnoreCase(nameOrAlias)) return level;
            for (String alias : level.getAlias()) if (alias.equalsIgnoreCase(nameOrAlias)) return level;
        }
        return null;
    }

    /**
     * Parse a course level list object from a grading profile config.
     *
     * @param config Grading profile.
     * @param parentPath Parent path to the levels section.
     * @return Parsed object.
     */
    public static CourseLevelList parseFromConfig(HyConfigBase config, String parentPath)
    {
        CourseLevelList result = new CourseLevelList();

        for (String key : config.getKeys(parentPath))
        {
            String entry = parentPath + "." + key;
            CLGradeWeightList weightList = CLGradeWeightList.parseFromConfig(config, entry + ".GradeWeight");
            ArrayList<String> alias = new ArrayList<>(config.getStringList(entry + ".Alias"));

            result.put(new CourseLevel(key, weightList, alias));
        }

        return result;
    }
}
