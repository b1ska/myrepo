package ru.spb.v6.balanceStat.supplier;

import ru.spb.v6.balanceStat.models.SupplierClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;

public class Internet_RTK extends SupplierClass {

    public Internet_RTK(String login, String password, String site, String description) {
        super(login, password, site, description);
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
            driver.get("https://lk.rt.ru/#payment/bankcard");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div[4]/div/div/section[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/span/span")));
            output = driver.findElement(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div[4]/div/div/section[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/span/span")).getText(); 
                
           
            output = output.replaceAll("[^-?,?0-9]+", "");
            output = output.substring(0, output.length() - 2);
  
        } catch (Exception ex) {
            System.out.println("Не удалось провертиь баланс");
            ex.getMessage();

        }
        driver.close();
        driver.quit();
        return "\n "+description+" " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
