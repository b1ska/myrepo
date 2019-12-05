/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceStat.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author b1ska
 */
public class ConfigureTable {

    private String type;
    private String login;
    private String password;

    private String site;
    private String description;

    public ConfigureTable() {
    }

    public ConfigureTable(String type, String login, String password, String site, String description) {
        this.type = type;
        this.login = login;
        this.password = password;
        this.site = site;
        this.description = description;
    }

    public void createSuppliersTable() throws SQLException {

        //создаем таблицу для поставщиков услуг
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/billing", "app", "app");
                Statement statement = connection.createStatement();) {

            statement.executeUpdate("CREATE TABLE SUPPLIERS_TABLE("
                    + "ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY\n"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "TYPE VARCHAR(255) NOT NULL, "
                    + "LOGIN VARCHAR(255) NOT NULL, "
                    + "PASSWORD VARCHAR(255) NOT NULL, "
                    + "SITE VARCHAR(255) NOT NULL,"
                    + "DESCRIPTION VARCHAR(255) NOT NULL)");

        }

    }

    public void createNewSupplier() throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/billing", "app", "app");
                Statement statement = connection.createStatement();) {
            //добавляем новый договор в базу
            statement.executeUpdate("INSERT INTO SUPPLIERS_TABLE (TYPE, LOGIN, PASSWORD, SITE, DESCRIPTION)\n"
                    + "VALUES (type, 'sao@v6.spb.ru', '11_D_33', 'https://my.yota.ru/selfcare/login?goto=https%3A%2F%2Fmy.yota.ru%3A443%2Fdevices', 'Интернет Пигмент Yota')");

        }
    }
}
