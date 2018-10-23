package cc.moecraft.school.veracross;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
@RequiredArgsConstructor
public class VeracrossReader
{
    private final String url;
    private final String username;
    private final String password;

    @Setter @Getter
    private WebDriver webDriver;

    /**
     * Initialize with default driver (Chrome driver)
     */
    public void initialize()
    {
        initialize(new ChromeDriver());
    }

    /**
     * Initialize with a specific web driver object.
     *
     * @param webDriver Selenium web driver object.
     */
    public void initialize(WebDriver webDriver)
    {
        setWebDriver(webDriver);
    }

    public void login()
    {

    }
}
