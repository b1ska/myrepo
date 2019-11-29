
package balanceStat.suppler;

import org.openqa.selenium.WebDriver;
import balanceStat.models.MailClass;
import balanceStat.models.SupplierClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Megafon_Telefon extends SupplierClass{
  
    //конструктор класса мегафон
public Megafon_Telefon(String login, String password, String site) {
        super(login, password, site);
        this.driver = super.driver;
        this.wait = super.wait;

 
}

 @Override
    public String chromeDriver() {
        
        try{
        super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login);    //вводим номер договора
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);             //вводим пароль
        driver.findElement(By.xpath("//*[@id=\"application\"]/div/main/div/div[1]/div/div/div/div/form/button/span")).click();                     //жмем логин
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"financial_info\"]/div[1]/div[1]/dl[1]/dd/div/span")));           //ждем появления поля с балансом
        
       
        output = driver.findElement(By.xpath("//*[@id=\"financial_info\"]/div[1]/div[1]/dl[1]/dd/div/span")).getText();             //берем баланс
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[4]/div/a")).click();                                  //жмем логаут
        driver.close();
        driver.quit();

        output = output.replaceAll("[^-?,?0-9]+", "");
        output = output.substring(0, output.length()-2);

        } catch (Exception ex) {
            ex.getMessage();

        }
        return "Текущий баланс договора Мегафон: " + login + "  " + formatForDateNow.format(date) + " равен: " + output;

    }



}