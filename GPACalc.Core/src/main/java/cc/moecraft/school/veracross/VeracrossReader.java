package cc.moecraft.school.veracross;

import cc.moecraft.school.utils.ElementUtils;
import cc.moecraft.school.veracross.pojo.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cc.moecraft.school.utils.ElementUtils.*;
import static cc.moecraft.school.utils.UrlUtils.makeUrl;
import static cc.moecraft.school.veracross.Attributes.HREF;
import static cc.moecraft.school.veracross.Attributes.INNER_HTML;
import static cc.moecraft.school.veracross.VeracrossUtils.*;
import static org.openqa.selenium.By.*;

/**
 * 此类由 Hykilpikonna 在 2018/10/05 创建!
 * Created by Hykilpikonna on 2018/10/05!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class VeracrossReader
{
    public static final String API_MESSAGES = "mailbox/messages";
    public static final String API_CALENDAR_EVENTS = "student/calendar/student/calendar_events";
    public static final String API_COURSE_ASSIGNMENTS = "student/enrollment/%CID%/assignments";
    public static final String API_COURSE_FEEDBACK = "student/enrollment/%CID%/feedback";

    private final String url;
    private final String username;
    private final String password;

    @Setter @Getter
    private WebDriver webDriver;

    /**
     * Construct a Veracross Reader object.
     *
     * @param url Base URL (eg. "https://portals-app.veracross.com/schoolname")
     * @param username Veracross Username
     * @param password Veracross Password
     */
    public VeracrossReader(String url, String username, String password)
    {
        this.url = url.endsWith("/") ? url : url + "/";
        this.username = username;
        this.password = password;
    }

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

    /**
     * Login with set username and password.
     */
    public void login()
    {
        // Send GET request to url.
        webDriver.get(url);

        // Put in username.
        WebElement usernameElement = webDriver.findElement(id("username"));
        usernameElement.sendKeys(username);

        // Put in password.
        WebElement passwordElement = webDriver.findElement(id("password"));
        passwordElement.sendKeys(password);

        // Submit form (Any element works)
        usernameElement.submit();
    }

    /**
     * Get courses.
     *
     * @return List of courses.
     */
    public List<VeracrossCourse> getCourses()
    {
        List<VeracrossCourse> result = new ArrayList<>();

        // Search for class list elements.
        List<WebElement> courses = findElements(getWebDriver(), cssSelector(".class-list.clear > li"));

        // Loops through each course to find detailed information.
        for (WebElement course : courses)
        {
            try
            {
                // Find course name and teacher name.
                // Inner HTML is more accurate than .text() because .text() doesn't work for invisible entries.
                WebElement courseNameElement = findElement(course, className("class-name"));
                String courseName = courseNameElement.getAttribute(INNER_HTML);
                String teacher = findElement(course, className("teacher-name")).getAttribute(INNER_HTML);
                long courseId = findCourseId(courseNameElement.getAttribute(HREF));
                long assignmentsId = findCourseId(findElement(course, className("view-assignments"))
                        .getAttribute(HREF));

                // Add to result.
                result.add(VeracrossCourse.builder()
                        .id(courseId)
                        .assignmentsId(assignmentsId)
                        .name(courseName)
                        .teacherName(teacher)
                        .build());
            }
            catch (ElementUtils.ElementNotFoundException ignored) {}
        }

        return result;
    }

    /**
     * Get data from an API Url
     *
     * @param apiUrl API Url
     * @param type Type of the response object.
     * @param params Parameter value pairs
     * @return Response
     */
    public <T> T get(String apiUrl, Type type, Object... params)
    {
        webDriver.get(makeUrl(url + apiUrl, params));
        String json = findElementRE(webDriver, cssSelector("pre")).getAttribute(INNER_HTML);
        return new Gson().fromJson(json, type);
    }

    /**
     * Get assignments of a course.
     *
     * @param courseId Course ID
     * @return Assignments
     */
    public VeracrossAssignments getAssignments(long courseId)
    {
        return get(replaceCourseId(API_COURSE_ASSIGNMENTS, courseId), VeracrossAssignments.class);
    }

    /**
     * Get messages.
     *
     * @param start Starting index of the message list.
     * @return Messages
     */
    public List<VeracrossMessage> getMessages(int start)
    {
        return get(API_MESSAGES, new TypeToken<List<VeracrossMessage>>(){}.getType(), "start", start);
    }

    /**
     * Get calendar events.
     *
     * @param begin Begin date.
     * @param end Ending date.
     * @return Calendar Events
     */
    public List<VeracrossCalendarEvent> getEvents(Date begin, Date end)
    {
        return get(API_CALENDAR_EVENTS, new TypeToken<List<VeracrossCalendarEvent>>(){}.getType()
                ,"begin_date", toVeracrossDate(begin)
                ,"end_date", toVeracrossDate(end));
    }

    /**
     * Get calendar events.
     *
     * @param begin Begin offset.
     * @param end Ending offset.
     * @return Calendar Events
     */
    public List<VeracrossCalendarEvent> getEvents(int begin, int end)
    {
        return getEvents(getDate(begin), getDate(end));
    }
}
