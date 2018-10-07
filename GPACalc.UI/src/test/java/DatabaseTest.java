import cc.moecraft.school.database.DatabaseInitializer;
import cc.moecraft.school.database.model.UserProfiles;
import cc.moecraft.school.database.service.UserProfileService;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class DatabaseTest
{
    public static void main(String[] args)
    {
        // Initialize
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.contextInitialized(null);

        // Create an entry
        UserProfiles profiles = new UserProfiles();
        profiles.setGoogleSub("test");
        profiles.setGradingProfile("A: B");
        profiles.setStudentProfile("A: B");
        profiles.save();

        // Find it
        System.out.println(new UserProfileService().findById("test"));
    }
}
