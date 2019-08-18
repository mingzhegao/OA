package generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * Mybatis的实体类,SQL映射文件,Mapper接口的自动生成工具
 * 使用方法:
 * 1,把generator包直接复制到src内
 * 2,把mybatis-generator-core-1.3.2.jar导包
 * 3,修改generatorConfig.xml配置文件
 * 	(1),连库设置
 *  (2),实体类包路径,SQL映射文件包路径,Mapper接口包路径
 *  (3),table节点的表名和实体类名
 * @author zhaogang
 * 注意: 仔细检查table节点的实体类名,不要与项目中已有实体类同名,除非你想覆盖
 */
public class Generator {

	public static void main(String[] args)  {
		 try {
			List<String> warnings = new ArrayList<String>();
			final boolean overwrite = true;
			File configFile = new File("src/generator/generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration configuration = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
			mybatisGenerator.generate(null);
			System.out.println("well done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
