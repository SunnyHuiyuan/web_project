package com.atguigu.ajax.app.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 操作的工具类
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    static {
        // 数据源只能被创建一次
        dataSource = new ComboPooledDataSource("ajaxapp");
    }

    /**
     * 返回数据源的一个 Connection 对象
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放 Connection 连接
     *
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConnection() throws SQLException {
        getConnection();
    }

}
