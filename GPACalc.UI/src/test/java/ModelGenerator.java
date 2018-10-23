import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static cc.moecraft.school.Constants.*;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * Meow!
 *
 * @author Hykilpikonna
 */
public class ModelGenerator
{
    public static void main(String[] args)
    {
        // The package that base model will be generated in
        String baseModelPkg = "cc.moecraft.school.database.model.base";
        String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/cc/moecraft/school/database/model/base/";

        // The package that model will be generated in.
        String modelPkg = "cc.moecraft.school.database.model";
        String modelDir = baseModelDir + "../";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(JDBC_CONNECTION);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        Generator generator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
        generator.generate();

        // Replace Model with JbootModel

    }

    private static void replaceText(File path, String... text)
    {
        if (path.isDirectory())
        {
            // Directory
            File[] files = path.listFiles();
            if (files != null)
                for (File file : files)
                    replaceText(file);
        }
        else
        {
            // File

            try
            {
                String content = new Scanner(path).useDelimiter("\\Z").next();

            }
            catch (FileNotFoundException e) { throw new RuntimeException(e); }
        }
    }
}
