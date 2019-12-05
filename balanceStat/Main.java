package balanceStat;

import balanceStat.helpers.*;
import balanceStat.models.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

     
        
        DoReport report = new DoReport();
        report.doReport();
        
        
        ConfigureTable table = new ConfigureTable();
        

      /*
        
        //Интернет NetByNet
        InternetNetbyNet officeMark = new InternetNetbyNet("1802649", "djccnfybz", "https://www.wifire.ru/");
        String balanceOfficeMark = officeMark.chromeDriver();
        InternetNetbyNet inetV9Kv38 = new InternetNetbyNet("1661993", "123456", "https://www.wifire.ru/");
        String balanceInetV9Kv38 = inetV9Kv38.chromeDriver();
        InternetNetbyNet officeOlga = new InternetNetbyNet("1754445", "123_D_123", "https://www.wifire.ru/");
        String balanceOfficeOlga = officeOlga.chromeDriver();
        InternetNetbyNet inetV9Kv34 = new InternetNetbyNet("1661665", "aGaNode2", "https://www.wifire.ru/");
        String balanceInetV9Kv34 = inetV9Kv34.chromeDriver();
        //ТВ Восстания 9
        TV_domRu tv38 = new TV_domRu("785000095501", "5b38ytib", "https://interzet.domru.ru/user/login");
        String balanceKV38 = tv38.chromeDriver();
        TV_domRu tv36 = new TV_domRu("785000100507", "iwih6p8q", "https://interzet.domru.ru/user/login");
        String balanceKV36 = tv36.chromeDriver();
        TV_domRu tv34 = new TV_domRu("785000091562", "2khb84v7", "https://interzet.domru.ru/user/login");
        String balanceKV34 = tv34.chromeDriver();
        
        //СМС.РУ
        SMSRU sms = new SMSRU("79110278006", "123_D_123", "http://sms.ru/");
        String balanceSMS = sms.chromeDriver();
        
        //Мегафон
        Megafon_Telefon chepurnoy = new Megafon_Telefon("SZF-9213457123", "xU4LS6", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceChep = chepurnoy.chromeDriver();
        Megafon_Telefon kozlov = new Megafon_Telefon("SZF-9213457926", "Yp7Zz9", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceKozlov = kozlov.chromeDriver();
        Megafon_Telefon korchaka = new Megafon_Telefon("SZF-9214140001", "7zZSMQ", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceKorchaka = korchaka.chromeDriver();
        Megafon_Telefon ginzburg = new Megafon_Telefon("SZF-9219854442", "OOra0U", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceGin = ginzburg.chromeDriver();
        Megafon_Telefon dmitrieva = new Megafon_Telefon("SZF-9219910019", "xrr7sU", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceDm = dmitrieva.chromeDriver();
        Megafon_Telefon rotan = new Megafon_Telefon("SZF-9312404122", "PU546A", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceRot = rotan.chromeDriver();
        Megafon_Telefon zhukov = new Megafon_Telefon("SZF-9213150011", "21pMLr", "https://szf.b2blk.megafon.ru/b2b/login");
        String balanceZhukov = zhukov.chromeDriver();*/
        // System.out.println("Интернет Кронверкская 27 " + balanceKronv);
      
       
    }

}
