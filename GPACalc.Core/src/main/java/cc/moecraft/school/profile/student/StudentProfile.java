package cc.moecraft.school.profile.student;

import cc.moecraft.yaml.HyConfigBase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@Getter @Setter
@ToString
public class StudentProfile
{
    private SubjectList subjectList;
    private StudentInformation information;

    private StudentProfile() {}

    /**
     * Parse a student profile object from a student profile config.
     *
     * @param config Student profile.
     * @param parentPath Parent path to the student profile. This should be "".
     * @return Parsed object.
     */
    public static StudentProfile parseFromConfig(HyConfigBase config, String parentPath)
    {
        StudentProfile result = new StudentProfile();

        result.setInformation(StudentInformation.parseFromConfig(config, parentPath + ".Basics"));
        result.setSubjectList(SubjectList.parseFromConfig(config, parentPath + ".Subjects"));

        return result;
    }

}
