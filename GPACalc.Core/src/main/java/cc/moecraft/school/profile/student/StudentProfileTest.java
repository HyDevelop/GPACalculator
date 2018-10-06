package cc.moecraft.school.profile.student;

import cc.moecraft.yaml.HyConfig;

import java.io.File;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class StudentProfileTest
{
    public static void main(String[] args)
    {
        HyConfig config = new HyConfig(new File("./profiles/student/Example.yml"));
        StudentProfile exampleProfile = StudentProfile.parseFromConfig(config, "");

        System.out.println(exampleProfile);
    }
}
