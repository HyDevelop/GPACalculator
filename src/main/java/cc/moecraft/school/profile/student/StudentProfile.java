package cc.moecraft.school.profile.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * Meow!
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

    

}
