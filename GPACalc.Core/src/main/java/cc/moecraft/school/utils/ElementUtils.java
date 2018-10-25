package cc.moecraft.school.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * 此类由 Hykilpikonna 在 2018/10/25 创建!
 * Created by Hykilpikonna on 2018/10/25!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class ElementUtils
{
    /**
     * Find an element, and returns null if not found.
     *
     * @param with Something that supports .findElements().
     * @param by What to search for.
     * @return Element found, null if not found.
     */
    public static WebElement findElementSafe(SearchContext with, By by)
    {
        List<WebElement> elements = with.findElements(by);
        return elements.size() == 0 ? null : elements.get(0);
    }
}
