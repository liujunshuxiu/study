package study.dada;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class RegionMap {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1,创建Druid连接池对象
//            DruidDataSource dataSource = new DruidDataSource();
//            InputStream inputStream = DruidStudy.ljclass.getClassLoader().getResourceAsStream("dbconfig.properties");

            File f = new File("C:/work/study/study/src/main/java/study.db/druid/druid.properties");
            InputStream in = new FileInputStream(f);
            Properties properties = new Properties();
            properties.load(in);
            DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            // 用Druid来连接
            conn = dataSource.getConnection();

            // 2,执行数据库语句
            String sql = "select * from  region ";

            // 3,用prepareStatement获取sql语句
            ps = conn.prepareStatement(sql);

            // 4,执行sql语句,查询用executeQuery,增删改用executeUpdate
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));

            }

            StringBuilder sb = new StringBuilder();
            sb.append("select * from  region ");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            conn.close();
        }
    }
}