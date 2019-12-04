
package balanceStat.models;


public class ReportModel {
    
    
    private String balanceDm;
    private String balanceKozlov;
    private String balanceChep;
    private String balanceGin;
    private String balanceKorchaka;
    private String balanceRot;
    private String balanceZhukov;
    private String balanceSMS;
    private String balanceKV38;
    private String balanceKV36;
    private String balanceKV34;
    private String balanceOfficeMark;
    private String balanceOfficeOlga;
    private String balanceInetV9Kv38;
    private String balanceInetV9Kv34;
    private String balanceYota;
    private String balanceNtvT14;
    private String balanceNtvX19;
    private String balanceOselkyInet;

    public ReportModel(String balanceDm, String balanceKozlov, String balanceChep, String balanceGin, String balanceKorchaka, String balanceRot, String balanceZhukov, String balanceSMS, String balanceKV38, String balanceKV36, String balanceKV34, String balanceOfficeMark, String balanceOfficeOlga, String balanceInetV9Kv38, String balanceInetV9Kv34, String balanceYota, String balanceNtvT14, String balanceNtvX19, String balanceOselkyInet) {
        this.balanceDm = balanceDm;
        this.balanceKozlov = balanceKozlov;
        this.balanceChep = balanceChep;
        this.balanceGin = balanceGin;
        this.balanceKorchaka = balanceKorchaka;
        this.balanceRot = balanceRot;
        this.balanceZhukov = balanceZhukov;
        this.balanceSMS = balanceSMS;
        this.balanceKV38 = balanceKV38;
        this.balanceKV36 = balanceKV36;
        this.balanceKV34 = balanceKV34;
        this.balanceOfficeMark = balanceOfficeMark;
        this.balanceOfficeOlga = balanceOfficeOlga;
        this.balanceInetV9Kv38 = balanceInetV9Kv38;
        this.balanceInetV9Kv34 = balanceInetV9Kv34;
        this.balanceYota = balanceYota;
        this.balanceNtvT14 = balanceNtvT14;
        this.balanceNtvX19 = balanceNtvX19;
        this.balanceOselkyInet = balanceOselkyInet;
    }
    
    
    
    
    
    public String getOtchet(){
        
        
        
     return "Мегфон--------------------------- \n "
                + "Дмитривева " + balanceDm
                + "\n Козлов " + balanceKozlov
                + "\n Чепурной " + balanceChep
                + "\n Гинзбург " + balanceGin
                + "\n Корчка " + balanceKorchaka
                + "\n Ротань " + balanceRot
                + "\n Жуков " + balanceZhukov
                + "\n СМС---------------------------"
                + "\n СМСРУ " + balanceSMS
                + "\n ТВ---------------------------"
                + "\n ТВ Восстания 9 кв 38 " + balanceKV38
                + "\n ТВ Восстания 9 кв 36 " + balanceKV36
                + "\n ТВ Восстания 9 кв 34 " + balanceKV34
                + "\n Интернет NetByNet---------------------------"
                + "\n Интернет офис Марка " + balanceOfficeMark
                + "\n Интернет офис Ольги  " + balanceOfficeOlga
                + "\n Интернет Восстания 9 кв 38 " + balanceInetV9Kv38
                + "\n Интернет Восстания 9 кв 34 " + balanceInetV9Kv34
                + "\n Интернет Yota---------------------------"
                + "\n Интернет Yota ИП Дмитриева " + balanceYota
                + "\n ТВ HTB ---------------------------"
                + "\n НТВ Тухачевского 14 " + balanceNtvT14
                + "\n НТВ Хасанская 19 " + balanceNtvX19
                + "\n Интернет Осельки ---------------------------"
                + "\n Интернет Осельки Asarta " + balanceOselkyInet;   
    }
}
