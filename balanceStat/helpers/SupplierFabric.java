/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceStat.helpers;

import balanceStat.models.SupplierClass;
import balanceStat.suppler.*;

/**
 *
 * @author b1ska
 */
public class SupplierFabric {

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
