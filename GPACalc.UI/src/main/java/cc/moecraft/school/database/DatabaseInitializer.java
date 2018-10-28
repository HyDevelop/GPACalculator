package cc.moecraft.school.database;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static cc.moecraft.school.Constants.*;
import static cc.moecraft.school.database.model._MappingKit.mapping;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
 *
 * @author Hykilpikonna
 */
public class DatabaseInitializer implements ServletContextListener
{
    public static C3p0Plugin c3p0Plugin;
    public static ActiveRecordPlugin activeRecordPlugin;

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {

    }

    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        c3p0Plugin = new C3p0Plugin(JDBC_CONNECTION, USERNAME, PASSWORD);
        c3p0Plugin.start();
        activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        mapping(activeRecordPlugin);
        activeRecordPlugin.start();
    }
}
