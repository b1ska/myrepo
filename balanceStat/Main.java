package balanceStat;

import balanceStat.suppler.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

         Internet_RTK kronverkskaya = new Internet_RTK("mozartspb@list.ru", "Test1234Axo", "https://b2c.passport.rt.ru/auth");
         String balanceKronv = kronverkskaya.chromeDriver();
       /* //Осельки Инетр Асарта
        Asarta oselkyInet = new Asarta("4703025405", "6n791w", "https://cabinet.asarta.ru/cabinet/welcome/");
        String balanceOselkyInet = oselkyInet.chromeDriver();
        
        //НТВ
        NTVplus ntvXass19 = new NTVplus("2286729599", "Королев", "https://service.ntvplus.ru/#tab2");
        String balanceNtvX19 = ntvXass19.chromeDriver();
        NTVplus ntvTyxa14 = new NTVplus("2275633241", "Королев", "https://service.ntvplus.ru/#tab2");
        String balanceNtvT14 = ntvTyxa14.chromeDriver();
        
        //Интернет Yota
        YotaInternet yota = new YotaInternet("sao@v6.spb.ru", "11_D_33", "https://my.yota.ru/selfcare/login?goto=https%3A%2F%2Fmy.yota.ru%3A443%2Fdevices");
        String balanceYota = yota.chromeDriver();
        
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
        TV_domRu tv38 = new TV_domRu("785000095501", "5b38ytib", "https://interzet.domru.ru/user/login?referrer=https%3A%2F%2Flk.domru.ru%2F");
        String balanceKV38 = tv38.chromeDriver();
        TV_domRu tv36 = new TV_domRu("785000100507", "iwih6p8q", "https://interzet.domru.ru/user/login?referrer=https%3A%2F%2Flk.domru.ru%2F");
        String balanceKV36 = tv36.chromeDriver();
        TV_domRu tv34 = new TV_domRu("785000091562", "2khb84v7", "https://interzet.domru.ru/user/login?referrer=https%3A%2F%2Flk.domru.ru%2F");
        String balanceKV34 = tv34.chromeDriver();
        */
        /*//СМС.РУ
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
        String balanceZhukov = zhukov.chromeDriver();
       
       
       
        System.out.println("Мегфон---------------------------");
        System.out.println("Дмитривева " + balanceDm);
        System.out.println("Козлов " + balanceKozlov);
        System.out.println("Чепурной " + balanceChep);
        System.out.println("Гинзбург " + balanceGin);
        System.out.println("Корчка " + balanceKorchaka);
        System.out.println("Ротань " + balanceRot);
        System.out.println("Жуков " + balanceZhukov);
        System.out.println("СМС---------------------------");
        System.out.println("СМСРУ " + balanceSMS);
        System.out.println("ТВ---------------------------");
        System.out.println("ТВ Восстания 9 кв 38 " + balanceKV38);
        System.out.println("ТВ Восстания 9 кв 36 " + balanceKV36);
        System.out.println("ТВ Восстания 9 кв 34 " + balanceKV34);
        System.out.println("Интернет NetByNet---------------------------");
        System.out.println("Интернет офис Марка " + balanceOfficeMark);
        System.out.println("Интернет офис Ольги  " + balanceOfficeOlga);
        System.out.println("Интернет Восстания 9 кв 38 " + balanceInetV9Kv38);
        System.out.println("Интернет Восстания 9 кв 34 " + balanceInetV9Kv34);
        System.out.println("Интернет Yota---------------------------");
        System.out.println("Интернет Yota ИП Дмитриева " + balanceYota);
       
        System.out.println("ТВ HTB ---------------------------");
        System.out.println("НТВ Тухачевского 14 " + balanceNtvT14);
        System.out.println("НТВ Хасанская 19 " + balanceNtvX19);
        System.out.println("Интернет Осельки ---------------------------");
        System.out.println("Интернет Осельки Asarta " + balanceOselkyInet); */

        System.out.println("Интернет Кронверкская 27 " + balanceKronv);
    }

}
