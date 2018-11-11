package cc.moecraft.school.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

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
     * Find an element, and throws a runtime exception when not found.
     *
     * This is used when the developer know for sure that there shouldn't be any error
     *   unless it's an error that requires updating the source code to fix.
     *
     * @param with Something that supports .findElements().
     * @param by What to search for.
     * @return Element found.
     */
    public static WebElement findElementRE(SearchContext with, By by)
    {
        try
        {
            return findElement(with, by);
        }
        catch (ElementNotFoundException e)
        {
            throw new RuntimeException("An really unexpected find element error occurred: ", e);
        }
    }

    /**
     * Find elements.
     *
     * @param with Something that supports .findElements().
     * @param by What to search for.
     * @return Elements found, empty list if not found.
     */
    public static List<WebElement> findElements(SearchContext with, By by)
    {
        return with.findElements(by);
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
