package cc.moecraft.school.veracross.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/25 创建!
 * Created by Hykilpikonna on 2018/10/25!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@Data
@AllArgsConstructor
@Builder
public class VeracrossCourse implements VeracrossPojo
{
    private String name;
    private String teacherName;
    private long id;
    private long assignmentsId;
}
