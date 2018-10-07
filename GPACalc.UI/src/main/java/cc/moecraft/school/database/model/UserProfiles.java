package cc.moecraft.school.database.model;

import cc.moecraft.school.database.model.base.BaseUserProfiles;
import cc.moecraft.school.database.service.UserProfileService;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class UserProfiles extends BaseUserProfiles<UserProfiles>
{
    /**
     * Get service instance.
     *
     * @return Service
     */
    public static UserProfileService service()
    {
        return UserProfileService.me();
    }
}
