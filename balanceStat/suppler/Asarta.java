/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author b1ska
 */
public class Asarta extends SupplierClass{
    
    
    public Asarta(String login, String password, String site) {
        super(login, password, site);
        this.driver = super.driver;
        this.wait = super.wait;

    }

    @Override
    public String chromeDriver() {
        
        try{
        super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-field\"]")));
        driver.findElement(By.xpath("//*[@id=\"login-field\"]")).sendKeys(login);    //вводим номер договора
        driver.findElement(By.xpath("//*[@id=\"pass-field\"]")).sendKeys(password);             //вводим пароль
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/div[2]/fieldset/button")).click();                         //жмем логин
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"text-2\"]/div/div[1]/div/div[8]/p[2]")));          //ждем появления поля с балансом
        output = driver.findElement(By.xpath("//*[@id=\"text-2\"]/div/div[1]/div/div[8]/p[2]")).getText();             //берем баланс
        driver.close();
        driver.quit();

        output = output.replaceAll("[^-?,?0-9]+", "");

        } catch (Exception ex) {
            ex.getMessage();

        }
        return "Текущий баланс договора: " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    
}
}