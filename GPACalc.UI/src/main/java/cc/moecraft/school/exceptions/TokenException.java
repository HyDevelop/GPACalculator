package cc.moecraft.school.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 此类由 Hykilpikonna 在 2018/10/06 创建!
 * Created by Hykilpikonna on 2018/10/06!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TokenException extends Exception
{
    private final String message;
}
