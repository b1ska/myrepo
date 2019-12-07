package balanceStat.helpers;

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
        try {
            con = DriverManager.getConnection(url, name, password);
        } catch (SQLException ex) {
            System.out.println("Не удалось подключиться к базе данных");
        }
        return con;
    }

}
