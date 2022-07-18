package com.lhx.stu_pro.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author luomo
 * @create 2022-07-16 9:20
 */
public class DruidUtil {
    //连接池
    private static DataSource dataSource;

    //static代码块，最先执行，且只执行一次
    static {
        //该方法从classpath[src]目录下查找指定文件
        InputStream inputStream =
                DruidUtil.class.getClassLoader().
                        getResourceAsStream("mysql.properties");
        //Properties 专门读取后缀名.properties文件
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回数据库连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //
    public static DataSource getDataSource(){
        return dataSource;
    }

}
