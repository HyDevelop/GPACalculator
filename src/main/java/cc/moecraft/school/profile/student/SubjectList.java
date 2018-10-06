package cc.moecraft.school.profile.student;

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
public class SubjectList
{
    private final ArrayList<Subject> subjects = new ArrayList<>();

    /**
     * Put a subject in the list.
     *
     * @param subject Level.
     */
    public void put(Subject subject)
    {
        subjects.add(subject);
    }

    /**
     * Search for a subject by name.
     *
     * @param name Name of the subject.
     * @return The subject. Returns null if not found.
     */
    public Subject searchByName(String name)
    {
        for (Subject subject : subjects) if (subject.getName().equalsIgnoreCase(name)) return subject;
        return null;
    }

    /**
     * Parse a subject list object from a student profile config.
     *
     * @param config Student profile.
     * @param parentPath Parent path to the subject list section.
     * @return Parsed object.
     */
    public static SubjectList parseFromConfig(HyConfig config, String parentPath)
    {
        SubjectList result = new SubjectList();

        for (String key : config.getKeys(parentPath))
        {
            String entry = parentPath + "." + key;

            result.put(new Subject(key,
                    config.getString(entry + ".Name"),
                    config.getString(entry + ".Level"),
                    config.getDouble(entry + ".Credits")
            ));
        }

        return result;
    }
}
