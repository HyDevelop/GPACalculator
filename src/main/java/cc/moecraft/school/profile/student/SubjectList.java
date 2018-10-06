package cc.moecraft.school.profile.student;

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
}
