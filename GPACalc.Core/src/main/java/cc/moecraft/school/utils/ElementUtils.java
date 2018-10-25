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
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ElementUtils
{
    /**
     * Find an element, and throw a catchable exception when not found.
     * This exists because the official .findElement() method throws an exception
     *   that I can't catch.
     *
     * @param with Something that supports .findElements().
     * @param by What to search for.
     * @return Element found.
     * @throws ElementNotFoundException Element not found.
     */
    public static WebElement findElement(SearchContext with, By by) throws ElementNotFoundException
    {
        WebElement element = findElementSafe(with, by);
        if (element == null) throw new ElementNotFoundException(by, with);
        return element;
    }

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

    /**
     * Element not found.
     */
    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor @Data
    public static class ElementNotFoundException extends Exception
    {
        private final By requestedBy;
        private final SearchContext requestedWith;
    }
}
