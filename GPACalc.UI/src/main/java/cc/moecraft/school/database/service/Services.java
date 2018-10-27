package cc.moecraft.school.database.service;

import cc.moecraft.school.database.model.TimeMap;
import cc.moecraft.school.database.model.UserInfo;
import io.jboot.JbootServiceBase;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class Services
{
    public static final ServiceUserInfo userInfo = new ServiceUserInfo();
    public static final ServiceTimeMap timeMap = new ServiceTimeMap();

    public static class ServiceUserInfo extends JbootServiceBase<UserInfo>
    {
        /**
         * Find UserInfo entry by google sub id.
         *
         * @param sub Sub id.
         * @return User info object.
         */
        public UserInfo findByGoogleSub(String sub)
        {
            return getDao().findFirstByColumn("google_sub", sub);
        }

        /**
         * Find UserInfo entry by discord id.
         *
         * @param discordId Discord id.
         * @return User info object.
         */
        public UserInfo findByDiscordId(String discordId)
        {
            return getDao().findFirstByColumn("discord_id", discordId);
        }
    }

    public static class ServiceTimeMap extends JbootServiceBase<TimeMap>
    {

    }
}
