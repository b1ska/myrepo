package balanceStat;

import balanceStat.actions.DoReport;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

          DoReport report = new DoReport();   //создаем класс
          report.doReport();                  //запускаем работу
        
        
        //ConfigureTable table = new ConfigureTable();  
        //table.createSuppliersTable();    //Создаем талицу поставщиков  если не созданна       
        // table.createNewSupplier(type, login, password, site, description);   //Создаем Новый договор
    }

}
