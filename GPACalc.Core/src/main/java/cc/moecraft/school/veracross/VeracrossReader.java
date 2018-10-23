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
 * QQ: admin@moecraft.cc -OR- 871674895
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
     * Initialize with a path to the chrome driver.
     *
     * @param chromeDriverPath Path to the chrome driver.
     */
    public void initialize(String chromeDriverPath)
    {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        initialize();
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
        // Send GET request to url.
        webDriver.get(url);

        // Put in username.
        WebElement usernameElement = webDriver.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        // Put in password.
        WebElement passwordElement = webDriver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        // Submit form (Any element works)
        usernameElement.submit();

        // TODO: Remove debug code
        System.out.println("Page Title: " + webDriver.getTitle());
    }
}
