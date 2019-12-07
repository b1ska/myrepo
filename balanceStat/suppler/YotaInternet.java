package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YotaInternet extends SupplierClass {

    public YotaInternet(String login, String password, String site, String description) {
        super(login, password, site, description);
        this.driver = super.driver;
        this.wait = super.wait;

    }

    @Override
    public String chromeDriver() {
        
        try{
        super.chromeDriver(); //To change body of generated methods, choose Tools | Templates.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yotaB2cAuth\"]/div/div[4]/form/div[5]/button/span")));   //ждем появления кнопки личный кбаинет  
        driver.findElement(By.xpath("//*[@id=\"authLoginText\"]")).sendKeys(login);    //вводим номер договора
        driver.findElement(By.xpath("//*[@id=\"authPasswordLogin\"]")).sendKeys(password);             //вводим пароль
        driver.findElement(By.xpath("//*[@id=\"yotaB2cAuth\"]/div/div[4]/form/div[5]/button/span")).click();                         //жмем логин
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/dl/dd/span")));                   //ждем отображение абалнса
        output = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/dl/dd/span")).getText();             //берем баланс

        output = output.replaceAll("[^-?,?0-9]+", ""); //форматируем вывод

        } catch (Exception ex) {
            System.out.println("Не удалось провертиь баланс");
            ex.getMessage();

        }
        driver.close();
        driver.quit();
        return "\n "+description+" " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
