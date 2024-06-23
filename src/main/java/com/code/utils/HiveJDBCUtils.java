package com.code.utils;

import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

/**
 * JDBC 操作 Hive
 */
@Slf4j
public class HiveJDBCUtils {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://" + HadoopUtils.Hadoop_IP + ":10000/default";// default 是默認數據庫名稱
    private static String user = "root";// hadoop中可以訪問hdfs的用戶
    private static String password = "root";// 該用戶的密碼

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        String sql = "show tables";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }


    /**
     * 获取Hive的连接执行操作
     *
     * @return
     * @throws Exception
     */
    public static Statement getConnStatement() throws Exception {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        return stmt;
    }

    @Before
    public void init() throws Exception {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    }


    // 创建数据库
    @Test
    public void createDatabase() throws Exception {
        String sql = "create database test";
        log.info("sql:{}", sql);
        stmt.execute(sql);
    }

    // 查询所有数据库
    @Test
    public void showDatabases() throws Exception {
        String sql = "show databases";
        log.info("sql:{}", sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 创建表
    @Test
    public void createTable() throws Exception {
        String sql = "create table test02 (id int ,name string) row format delimited fields terminated by  '\\t' ";
        log.info("sql:{}", sql);
        stmt.execute(sql);
    }

    // 查询所有表
    @Test
    public void showTables() throws Exception {
        String sql = "show tables";
        log.info("sql:{}", sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 查看表结构
    @Test
    public void descTable() throws Exception {
        String sql = "desc emp";
        log.info("sql:{}", sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));
        }
    }

    // 加载数据
    @Test
    public void loadData() throws Exception {
        String filePath = "/home/hadoop/data/emp.txt";
        String sql = "load data local inpath '" + filePath + "' overwrite into table test";
        log.info("sql:{}", sql);
        stmt.execute(sql);
    }

    // 查询数据
    @Test
    public void selectData() throws Exception {
        String sql = "select * from test";
        log.info("sql:{}", sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t\t" + rs.getString("name"));
        }
    }

    // 统计查询（会运行mapreduce作业）
    @Test
    public void countData() throws Exception {
        String sql = "select count(1) from test";
        log.info("sql:{}", sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
    }

    // 删除数据库
    @Test
    public void dropDatabase() throws Exception {
        String sql = "drop database if exists test";
        log.info("sql:{}", sql);
        stmt.execute(sql);
    }

    // 删除数据库表
    @Test
    public void deopTable() throws Exception {
        String sql = "drop table if exists test";
        log.info("sql:{}", sql);
        stmt.execute(sql);
    }

    // 释放资源
    @After
    public void destory() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }


}
