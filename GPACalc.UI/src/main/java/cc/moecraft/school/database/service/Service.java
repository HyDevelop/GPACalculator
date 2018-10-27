package cc.moecraft.school.database.service;

import cc.moecraft.school.database.model.TimeMap;
import cc.moecraft.school.database.model.UserInfo;
import cc.moecraft.school.database.model.UserProfiles;
import io.jboot.JbootServiceBase;

/**
 * 此类由 Hykilpikonna 在 2018/10/27 创建!
 * Created by Hykilpikonna on 2018/10/27!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class Service
{
    public static final JbootServiceBase<TimeMap> TIME_MAP = new JbootServiceBase<>();
    public static final JbootServiceBase<UserInfo> USER_INFO = new JbootServiceBase<>();
    public static final JbootServiceBase<UserProfiles> USER_PROFILES = new JbootServiceBase<>();
}
