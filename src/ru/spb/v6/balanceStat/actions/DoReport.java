package ru.spb.v6.balanceStat.actions;

import ru.spb.v6.balanceStat.helpers.*;
import ru.spb.v6.balanceStat.models.SupplierClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    public void doReport() throws SQLException {

        //подключаемся к базе
        con = ConncectionManager.getConnection();
        stmt = con.createStatement();

        //делаем запрос в базу, и забираем из нее необходимые данные
        rs = stmt.executeQuery("select * from SUPPLIERS_TABLE");
        List<String> reportList = new ArrayList();
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
            SupplierClass supplier = new SupplierFabric().createSupplier(type, login, password, site, description);
            String reportString = supplier.chromeDriver();

            //добавляем данные с сайтов в список
            reportList.add(reportString);

        }
        
        

        //сохраняет отчет при проверке баланса
        ps = con.prepareStatement("UPDATE REPORTS SET report=?");
        ps.setString(1, reportList.toString());
        ps.executeUpdate();
    
        //создаем обект sendMail и передаем ему список для отправки
        SendMailClass mail = new SendMailClass(reportList);
        mail.sendMail(); //отправляем отчет на почту

    }
}
