package balanceStat.actions;

import balanceStat.helpers.ConncectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

/**
 *
 * @author b1ska
 */
public class ConfigureTable {

    private Connection con = null;
    private PreparedStatement ps = null;
    private Statement stmt = null;

    //создаем новую таблицу для поставщиков услуг, если она не созданна
    public void createSuppliersTable() throws SQLException {  

        con = ConncectionManager.getConnection();
        stmt = con.createStatement();

        stmt.executeUpdate("CREATE TABLE SUPPLIERS_TABLE("
                + "TYPE VARCHAR(255) NOT NULL, "
                + "LOGIN VARCHAR(255) NOT NULL, "
                + "PASSWORD VARCHAR(255) NOT NULL, "
                + "SITE VARCHAR(255) NOT NULL,"
                + "DESCRIPTION VARCHAR(255) NOT NULL)");

    }

     //метод для создание нового договора в базе 
    public void createNewSupplier(String type, String login, String password, String site, String description) throws SQLException {       

        con = ConncectionManager.getConnection();
        ps = con.prepareStatement("INSERT INTO SUPPLIERS_TABLE (TYPE, LOGIN, PASSWORD, SITE, DESCRIPTION)"
                + " VALUES (?,?,?,?,?)");
        ps.setString(1, type);
        String encodedLogin = Base64.getEncoder().encodeToString(login.getBytes());//кодируем логин
        ps.setString(2, encodedLogin);
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());//кодируем пароль
        ps.setString(3, encodedPassword);
        ps.setString(4, site);
        ps.setString(5, description);
        ps.executeUpdate();

    }
}
