package ru.spb.v6.balanceStat.actions;

import ru.spb.v6.balanceStat.helpers.ConncectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import ru.spb.v6.balanceStat.helpers.SupplierFabric;
import ru.spb.v6.balanceStat.models.SupplierClass;

/**
 *
 * @author b1ska
 */
public class ConfigureTable implements Action {

    private Connection con;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private PreparedStatement ps;
    private Statement stmt;

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

    public void showTable() throws SQLException {
        con = ConncectionManager.getConnection();
        stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select * from SUPPLIERS_TABLE");
        while (rs.next()) {

            //получаем данные из базы и декодируем 
            String type = rs.getString(1);
            String description = rs.getString(5);

            //создаем обекты Suupliers в цикел и забираем данные с сайтов.
            String tableList = type + " " + description;

            //добавляем данные с сайтов в список
            System.out.println(tableList);
        }
        System.out.println("\n-----------------------------------------------");
    }
}
