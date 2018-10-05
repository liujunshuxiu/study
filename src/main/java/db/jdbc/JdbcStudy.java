package db.jdbc;

import java.sql.*;

public class JdbcStudy {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";
//        String sql = "update blog set name = ? where id=?";
        String sql = "select * from  ss_ssc_project_config ";
        Connection con = null; //一个封装了TCP长连接 的 数据库长连接对象
//        Statement stmt = null; //一个封装和管理SQL语句的java对象
        ResultSet rSet = null; //一个封装了数据对象 的 无序集合对象

        try {
            // 1.获取连接
            con = DriverManager.getConnection(url, username, password);

            // 2.创建 preparedStatement
            PreparedStatement prepareStatement = con.prepareStatement(sql);

            // 3.初始化参数
//            prepareStatement.setString(1, "lucy");
//            prepareStatement.setInt(2, 1);

            // 4.执行update
//           prepareStatement.executeUpdate();
            rSet = prepareStatement.executeQuery();
            while(rSet.next()){
                System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rSet!=null){ rSet.close();}
            if(con!=null){con.close();}
        }

    }
}
