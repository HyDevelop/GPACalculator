package cc.moecraft.school.veracross;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 此类由 Hykilpikonna 在 2018/11/07 创建!
 * Created by Hykilpikonna on 2018/11/07!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
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
}
