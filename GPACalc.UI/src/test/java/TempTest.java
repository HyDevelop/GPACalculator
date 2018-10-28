import cc.moecraft.school.Grades;

import static cc.moecraft.school.Constants.GSON;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class TempTest
{
    public static void main(String[] args)
    {
        Grades grades = new Grades()
                .putGrade("English 2 A", "A-")
                .putGrade("Algebra 2 H", "A+")
                .putGrade("Chemistry 1 H", "B+")
                .putGrade("Modern World History CP", "A+")
                .putGrade("Early Church CP", "B+")
                .putGrade("AP Computer Science A", "A+");

        System.out.println(GSON.toJson(grades));
    }
}

