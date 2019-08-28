import cc.moecraft.school.veracross.VeracrossReader;
import cc.moecraft.school.veracross.pojo.VeracrossAssignments;
import cc.moecraft.school.veracross.pojo.VeracrossCalendarEvent;
import cc.moecraft.school.veracross.pojo.VeracrossCourse;
import cc.moecraft.school.veracross.pojo.VeracrossMessage;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 此类由 Hykilpikonna 在 2018/10/23 创建!
 * Created by Hykilpikonna on 2018/10/23!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class VeracrossTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Ask for username
        System.out.println("Veracross Username?");
        String user = in.nextLine();

        // Ask for passwd
        System.out.println("Veracross Password?");
        String pass = in.nextLine();

        // Test
        test(user, pass);
    }

    public static void test(String user, String pass)
    {
        // Initialize object with base url, username and password.
        VeracrossReader reader = new VeracrossReader("https://portals-app.veracross.com/sjp", user, pass);

        // Initialize browser driver.
        reader.initialize("./GPACalc.Core/drivers/chromedriver.exe", false);

        // Login
        reader.login();

        // Get courses
        List<VeracrossCourse> courses = reader.getCourses();
        log(courses);

        // Get assignments of the course at index 1 of the list.
        VeracrossAssignments assignments = reader.getAssignments(courses.get(1).getAssignmentsId());
        log(assignments);

        // Get messages starting at index 0.
        List<VeracrossMessage> messages = reader.getMessages(0);
        log(messages);

        // Get calendar events from 5 days ago to 5 days later.
        List<VeracrossCalendarEvent> events = reader.getEvents(-5, 5);
        log(events);

        // Get calendar events from a specific date to a specific date.
        events = reader.getEvents(new Date(), new Date());
        log(events);

        // Kill browser task.
        reader.destroy();
    }

    public static void log(Object object)
    {
        System.out.println(String.valueOf(new Gson().toJson(object)));
        System.out.println("--------======= LINE OF SEPARATION =======--------");
    }
}
