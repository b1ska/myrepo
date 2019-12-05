package balanceStat.helpers;

import balanceStat.models.SupplierClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author b1ska
 */
public class DoReport {

    public void doReport() throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/billing", "app", "app");
                Statement statement = connection.createStatement();) {

            ResultSet rs = statement.executeQuery("select * from SUPPLIERS_TABLE");
            List<String> result = new ArrayList<String>();
            while (rs.next()) {
                String type = rs.getString(2);
                String login = rs.getString(3);
                String password = rs.getString(4);
                String site = rs.getString(5);
                String description = rs.getString(6);

                SupplierClass test = new SupplierFabric().createSupplier(type, login, password, site, description);
                String ts = test.chromeDriver();

                result.add(ts);

            }
            SendMailClass mail = new SendMailClass(result);
            mail.sendMail(); //отправляем отчет на почту

        }

    }

}
