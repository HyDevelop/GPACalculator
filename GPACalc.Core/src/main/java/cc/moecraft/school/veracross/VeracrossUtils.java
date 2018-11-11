package cc.moecraft.school.veracross;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 此类由 Hykilpikonna 在 2018/11/07 创建!
 * Created by Hykilpikonna on 2018/11/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class VeracrossUtils
{
    public static final Pattern COURSE_ID_PATTERN = Pattern.compile("(?<=/).[0-9]*(?=/)");

    /**
     * Find course id in url.
     *
     * @param courseUrl Url (eg. "/course/12345/website/")
     * @return Course ID
     */
    public static long findCourseId(String courseUrl)
    {
        courseUrl += "/";
        Matcher matcher = COURSE_ID_PATTERN.matcher(courseUrl);

        if (matcher.find()) return Long.parseLong(matcher.group());
        return 0;
    }

    /**
     * Replace course ID
     *
     * @param url API url
     * @param id Course ID
     * @return URL with course ID
     */
    public static String replaceCourseId(String url, long id)
    {
        return url.replace("%CID%", String.valueOf(id));
    }

    /**
     * Convert Date object to Veracross parameter date format.
     *
     * @param date Date object
     * @return Date string.
     */
    public static String toVeracrossDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new SimpleDateFormat("mm%2Fdd%2Fyyyy").format(date);
    }

    /**
     * Get date with day offset.
     * Eg. getDate(-5) would return a Date from 5 days ago.
     *
     * @param dayOffset Day offset
     * @return Date
     */
    public static Date getDate(int dayOffset)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, dayOffset);
        return calendar.getTime();
    }
}
