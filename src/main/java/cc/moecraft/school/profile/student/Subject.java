package cc.moecraft.school.profile.student;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
@AllArgsConstructor @Data
public class Subject
{
    /**
     * The name of the key in config. (eg. "Course1")
     */
    private String keyName;

    /**
     * The name of the course. (eg. "English 2 A")
     */
    private String name;

    /**
     * The name of the level. (eg. "AP")
     */
    private String level;

    /**
     * Credits. (eg. 1)
     */
    private double credits;
}
