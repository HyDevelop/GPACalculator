package cc.moecraft.school.veracross;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/25 创建!
 * Created by Hykilpikonna on 2018/10/25!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@Data
@AllArgsConstructor
@Builder
public class VeracrossCourseGrade
{
    private long courseId;
    private String url;

    private String name;
    private String teacherName;
    private String letterGrade;
    private double numericGrade;
}
