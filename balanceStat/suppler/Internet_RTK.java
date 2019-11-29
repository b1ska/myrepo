package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Internet_RTK extends SupplierClass {

    public Internet_RTK(String login, String password, String site) {
        super(login, password, site);
        this.driver = super.driver;
        this.wait = super.wait;

    }

    @Override
    public String chromeDriver() {

        try {
            super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));   //ждем появления кнопки личный кбаинет
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(login);                          //вводим номер договора
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);                         //вводим пароль
            driver.findElement(By.xpath("//*[@id=\"kc-login\"]")).click();                                  //жмем логин
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cabinets\"]/a")));
            driver.findElement(By.xpath("//*[@id=\"cabinets\"]/a")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a/img")));
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a/img")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement test = driver.findElement(By.cssSelector(".sum.mainpage.nowrap.margin-bottom-m.medium-balance"));
            

            driver.close();
            driver.quit();

            output = output.replaceAll("[^-?,?0-9]+", "");
            output = output.substring(0, output.length() - 2);
        } catch (Exception ex) {
            ex.getMessage();

        }
        return "Текущий баланс договора, на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
