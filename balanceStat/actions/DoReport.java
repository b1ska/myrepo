package balanceStat.actions;

import balanceStat.helpers.ConncectionManager;
import balanceStat.helpers.SupplierFabric;
import balanceStat.models.SupplierClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author b1ska
 */
public class DoReport {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

  
    public void doReport() throws SQLException {

        //подключаемся к базе
        con = ConncectionManager.getConnection();
        stmt = con.createStatement();
          
        //делаем запрос в базу, и забираем из нее необходимые данные
        ResultSet rs = stmt.executeQuery("select * from SUPPLIERS_TABLE");
        List<String> result = new ArrayList();
        while (rs.next()) {

            //получаем данные из базы и декодируем 
            String type = rs.getString(1);
            String codeLogin = rs.getString(2);
            byte[] decodedLoginBytes = Base64.getDecoder().decode(codeLogin); //декодируем логин
            String login = new String(decodedLoginBytes);
            String codePassword = rs.getString(3);
            byte[] decodedPasswordBytes = Base64.getDecoder().decode(codePassword); //декодируем пароль
            String password = new String(decodedPasswordBytes);
            String site = rs.getString(4);
            String description = rs.getString(5);

            
            //создаем обекты Suupliers в цикел и забираем данные с сайтов.
            SupplierClass test = new SupplierFabric().createSupplier(type, login, password, site, description);
            String ts = test.chromeDriver();

            //добавляем данные с сайтов в список
            result.add(ts);

        }
        //создаем обект sendMail и передаем ему список для отправки
        SendMailClass mail = new SendMailClass(result);
        mail.sendMail(); //отправляем отчет на почту

    }

}
