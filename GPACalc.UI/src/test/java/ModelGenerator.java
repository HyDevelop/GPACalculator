import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static cc.moecraft.school.Constants.*;

/**
 * 此类由 Hykilpikonna 在 2018/10/07 创建!
 * Created by Hykilpikonna on 2018/10/07!
 * Github: https://github.com/hykilpikonna
 * QQ: admin@moecraft.cc -OR- 871674895
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
        replaceText(new File(modelDir),
                "import com.jfinal.plugin.activerecord.Model;", "import io.jboot.JbootModel;",
                " extends Model<M>", " extends JbootModel<M>");
    }

    private static void replaceText(File path, String... text)
    {
        if (path.isDirectory()) // Directory
        {
            File[] files = path.listFiles();
            if (files != null) for (File file : files) replaceText(file, text);
        }
        else
        {
            try // File
            {
                String content = FileUtils.readFileToString(path, "utf-8");

                for (int i = 0; i < text.length; i += 2)
                {
                    if (i + 1 > text.length) break;

                    String from = text[i];
                    String to = text[i + 1];

                    content = content.replace(from, to);
                }

                FileUtils.writeStringToFile(path, content, "utf-8");
            }
            catch (java.io.IOException e) { throw new RuntimeException(e); }
        }
    }
}
