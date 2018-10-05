package db.druid;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidStudy {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1,创建Druid连接池对象
            DruidDataSource dataSource = new DruidDataSource();

            // 2,为数据库添加配置文件
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");

            dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");

            // 用Druid来连接
            conn = dataSource.getConnection();

            // 2,执行数据库语句
            String sql = "select * from  ss_ssc_project_config ";

            // 3,用prepareStatement获取sql语句
            ps = conn.prepareStatement(sql);

            // 4,执行sql语句,查询用executeQuery,增删改用executeUpdate
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            conn.close();
        }
    }
}
