package cc.moecraft.school.veracross;

import cc.moecraft.school.utils.ElementUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static cc.moecraft.school.utils.ElementUtils.findElement;
import static cc.moecraft.school.utils.ElementUtils.findElements;

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
    public static final Pattern COURSE_ID_PATTERN = Pattern.compile("(?<=/)[0-9]*(?=/)");

    private final String url;
    private final String username;
    private final String password;

    @Setter @Getter
    private WebDriver webDriver;

    /**
     * Initialize with a path to the chrome driver.
     * Headless default true.
     *
     * @param chromeDriverPath Path to the chrome driver.
     */
    public void initialize(String chromeDriverPath)
    {
        initialize(chromeDriverPath, true);
    }

    /**
     * Initialize with a path to the chrome driver.
     *
     * @param chromeDriverPath Path to the chrome driver.
     * @param headless Headless = run on background.
     */
    public void initialize(String chromeDriverPath, boolean headless)
    {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions chromeOptions = new ChromeOptions();

        if (headless) chromeOptions.addArguments("--headless");

        initialize(new ChromeDriver(chromeOptions));
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

    /**
     * Get courses.
     *
     * @return List of courses.
     */
    public List<VeracrossCourse> getCourses()
    {
        List<VeracrossCourse> result = new ArrayList<>();

        // If I search for .course, it would only include the course name and teacher name
        // Because the grades are stored in .course-notifications, which are parallel elements.
        // So I have to search for the list entry elements that stores both of them.
        List<WebElement> courses = findElements(getWebDriver(), By.cssSelector(".class-list.clear > li"));

        // Loops through each course to find detailed information.
        for (WebElement course : courses)
        {
            try
            {
                // Find course name and teacher name.
                // Inner HTML is more accurate than .text() because .text() doesn't work for invisible entries.
                WebElement courseNameElement = findElement(course, By.className("class-name"));
                String courseName = courseNameElement.getAttribute("innerHTML");
                String courseUrl = courseNameElement.getAttribute("href");
                String teacher = findElement(course, By.className("teacher-name")).getAttribute("innerHTML");
                long courseId = Long.parseLong(COURSE_ID_PATTERN.matcher(courseUrl).group());

                result.add(VeracrossCourse.builder()
                        .courseId(courseId)
                        .url(courseUrl)
                        .name(courseName)
                        .teacherName(teacher)
                        .build());
            }
            catch (ElementUtils.ElementNotFoundException ignored) {}
        }

        return result;
    }
}
