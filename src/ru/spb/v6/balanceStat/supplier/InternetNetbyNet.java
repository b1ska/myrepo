package ru.spb.v6.balanceStat.supplier;

import ru.spb.v6.balanceStat.models.SupplierClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InternetNetbyNet extends SupplierClass {

    public InternetNetbyNet(String login, String password, String site,String description) {
        super(login, password, site, description);
        this.driver = super.driver;
        this.wait = super.wait;
    }

    @Override
    public String chromeDriver() {

        try {
            super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"body_wrapper\"]/div[1]/div[1]/div/div/div/div[2]/a[3]")));   //ждем появления кнопки личный кбаинет
            driver.findElement(By.xpath("//*[@id=\"body_wrapper\"]/div[1]/div[1]/div/div/div/div[2]/a[3]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-content\"]/div/form/div[1]/div[1]/div[1]/input"))); //ждем появления ввода пароля
            driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/form/div[1]/div[1]/div[1]/input")).sendKeys(login);    //вводим номер договора
            driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/form/div[2]/div[1]/div[1]/input")).sendKeys(password);             //вводим пароль
            driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/form/div[6]/div/div/button")).click();                         //жмем логин
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"balance-place\"]/div/article/div[1]/div[2]")));   //ждем появления поля с балансом
            output = driver.findElement(By.xpath("//*[@id=\"balance-place\"]/div/article/div[1]/div[2]")).getText();             //берем баланс
            driver.findElement(By.xpath("//*[@id=\"main-container\"]/header/div[1]/div/div/div[2]/a[3]/span")).click();                                  //жмем логаут

            output = output.replaceAll("[^-?,?0-9]+", "");

        } catch (Exception ex) {
            System.out.println("Не удалось провертиь баланс");
            ex.getMessage();

        }
        driver.close();
        driver.quit();
        return "\n "+description+" " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
