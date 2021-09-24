package study.db.jdbc;

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.util.Random;

public class JdbcStudy {

    public static void insFlower(Random rand) {
        int index = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj_test_db1?serverTimezone=UTC&characterEncoding=utf-8", "root", "123456");

            ps = conn.prepareStatement("insert into single_table (`key1`, `key2`, `key3`,`key_part1`, `key_part2`, `key_part3`,`common_field`) values (?,?,?,?,?,?,?)");//!!!! default ?

            ps.setObject(1, RandomStringUtils.randomAlphanumeric(10));
            ps.setObject(2, rand.nextInt(99999999));
            ps.setObject(3, RandomStringUtils.randomAlphanumeric(50));
            ps.setObject(4, RandomStringUtils.randomAlphanumeric(50));
            ps.setObject(5, RandomStringUtils.randomAlphanumeric(50));
            ps.setObject(6, RandomStringUtils.randomAlphanumeric(50));
            ps.setObject(7, RandomStringUtils.randomAlphanumeric(50));

            index = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Random rand = new Random();
        for(int i = 0;i<10000;i++ ){
            insFlower(rand);
            System.out.println(i);
        }
    }

//    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/lj_test_db1";
//        String username = "root";
//        String password = "123456";
////        String sql = "update blog set name = ? where id=?";
//        String sql = "select * from  page_demo ";
//        Connection con = null; //一个封装了TCP长连接 的 数据库长连接对象
////        Statement stmt = null; //一个封装和管理SQL语句的java对象
//        ResultSet rSet = null; //一个封装了数据对象 的 无序集合对象
//
//        try {
//            // 1.获取连接
//            con = DriverManager.getConnection(url, username, password);
//
//            // 2.创建 preparedStatement
//            PreparedStatement prepareStatement = con.prepareStatement(sql);
//
//            // 3.初始化参数
////            prepareStatement.setString(1, "lucy");
////            prepareStatement.setInt(2, 1);
//
//            // 4.执行update
////           prepareStatement.executeUpdate();
//            rSet = prepareStatement.executeQuery();
//            while(rSet.next()){
//                System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(rSet!=null){ rSet.close();}
//            if(con!=null){con.close();}
//        }
//
//    }
}
