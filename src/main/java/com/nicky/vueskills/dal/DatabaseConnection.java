package com.nicky.vueskills.dal;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection
{
    public Connection getDatabaseConnection()
    {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("77.251.225.24");
        dataSource.setUser("vueskills");
        dataSource.setPassword("OzOc5NHrMoidwD3VkzzY");
        dataSource.setDatabaseName("vueskills");

        try
        {
            return (Connection) dataSource.getConnection();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
