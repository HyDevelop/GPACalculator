package cc.moecraft.school;

import lombok.Getter;
import lombok.ToString;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@Getter
public enum Grades
{
    A_PLUS  ("A+"),
    A       ("A"),
    A_MINUS ("A-"),
    B_PLUS  ("B+"),
    B       ("B"),
    B_MINUS ("B-"),
    C_PLUS  ("C+"),
    C       ("C"),
    C_MINUS ("C-"),
    D_PLUS  ("D+"),
    D       ("D"),
    D_MINUS ("D-"),
    FAIL    ("F");

    private String name;

    Grades(String name, String... alias)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
