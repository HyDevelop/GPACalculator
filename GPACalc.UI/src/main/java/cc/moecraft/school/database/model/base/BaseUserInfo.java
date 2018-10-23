package cc.moecraft.school.database.model.base;

import io.jboot.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserInfo<M extends BaseUserInfo<M>> extends JbootModel<M> implements IBean {

	public void setUserId(java.lang.Integer userId) {
		set("user_id", userId);
	}
	
	public java.lang.Integer getUserId() {
		return getInt("user_id");
	}

	public void setGoogleSub(java.lang.String googleSub) {
		set("google_sub", googleSub);
	}
	
	public java.lang.String getGoogleSub() {
		return getStr("google_sub");
	}

	public void setDiscordId(java.lang.String discordId) {
		set("discord_id", discordId);
	}
	
	public java.lang.String getDiscordId() {
		return getStr("discord_id");
	}

}
