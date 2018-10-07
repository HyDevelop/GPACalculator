import cc.moecraft.school.Constants;
import com.jfinal.core.Const;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

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
        String baseModelDir = PathKit.getWebRootPath() + "/generated/model/base";

        // The package that model will be generated in.
        String modelPkg = "cc.moecraft.school.database.model";
        String modelDir = baseModelDir + "/generated/model";

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(JDBC_CONNECTION);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        Generator gernerator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
        gernerator.generate();
    }
}
