package ru.spb.v6.balanceStat.helpers;

import ru.spb.v6.balanceStat.supplier.TV_domRu;
import ru.spb.v6.balanceStat.supplier.Internet_RTK;
import ru.spb.v6.balanceStat.supplier.SMSRU;
import ru.spb.v6.balanceStat.supplier.Asarta;
import ru.spb.v6.balanceStat.supplier.NTVplus;
import ru.spb.v6.balanceStat.supplier.YotaInternet;
import ru.spb.v6.balanceStat.supplier.Megafon_Telefon;
import ru.spb.v6.balanceStat.supplier.InternetNetbyNet;
import ru.spb.v6.balanceStat.models.SupplierClass;

/**
 *
 * @author b1ska
 */
public class SupplierFabric {

    
    //фабричный метод для создания объектов из базы
    public SupplierClass createSupplier(String supplierType, String login, String password, String site, String description) {
        switch (supplierType) {
            case "Asarta":
                return new Asarta(login, password, site, description);
            case "InternetNetbyNet":
                return new InternetNetbyNet(login, password, site, description);
            case "Internet_RTK":
                return new Internet_RTK(login, password, site, description);
            case "Megafon_Telefon":
                return new Megafon_Telefon(login, password, site, description);
            case "NTVplus":
                return new NTVplus(login, password, site, description);
            case "SMSRU":
                return new SMSRU(login, password, site, description);
            case "TV_domRu":
                return new TV_domRu(login, password, site, description);
            case "YotaInternet":
                return new YotaInternet(login, password, site, description);
            default:
                return null;
        }
    }
}
