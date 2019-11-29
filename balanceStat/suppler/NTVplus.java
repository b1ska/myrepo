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
public class NTVplus extends SupplierClass {

    public NTVplus(String login, String password, String site) {
        super(login, password, site);
        this.driver = super.driver;
        this.wait = super.wait;

    }

    @Override
    public String chromeDriver() {
        
        try{
        super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab2\"]/form/div[1]/div[2]/input")));   //ждем появления кнопки личный кбаинет         
        driver.findElement(By.xpath("//*[@id=\"tab2\"]/form/div[1]/div[2]/input")).sendKeys(login);    //вводим номер договора
        driver.findElement(By.xpath("//*[@id=\"tab2\"]/form/div[2]/div[2]/input")).sendKeys(password);             //вводим пароль
        driver.findElement(By.xpath("//*[@id=\"tab2\"]/form/div[4]/div/button")).click();                         //жмем логин
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab2\"]/form/div[3]/div[2]/div/div"))); //ждем появления поля с балансом         
        output = driver.findElement(By.xpath("//*[@id=\"tab2\"]/form/div[3]/div[2]/div/div")).getText();             //берем баланс
        driver.close();
        driver.quit();

       
          output = output.replaceAll("[^-?,?0-9]+", "");
          output = output.substring(0, output.length() - 2);

        } catch (Exception ex) {
            ex.getMessage();

        }
        return "Текущий баланс договора: " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
