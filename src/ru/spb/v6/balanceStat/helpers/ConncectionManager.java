package ru.spb.v6.balanceStat.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author b1ska
 */
public class ConncectionManager {

    private static String url = "jdbc:derby://localhost:1527/billing";
    private static String name = "app";
    private static String password = "app";
    private static Connection con;

    //метод для создания подключения к базе
    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(url, name, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Не удалось подключиться к базе данных");
            }
        }
        return con;
    }
}
