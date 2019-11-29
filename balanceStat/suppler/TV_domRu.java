package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class TV_domRu extends SupplierClass {

    public TV_domRu(String login, String password, String site) {
        super(login, password, site);
        this.driver = super.driver;
        this.wait = super.wait;
    }

    public String chromeDriver() {

        try {

            super.chromeDriver();
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NetBeans 8.2\\java\\webdriver\\chromedriver.exe");
          
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div/input")).sendKeys(login);    //вводим номер договора
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(password);             //вводим пароль
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/button")).click();                         //жмем логин
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div/a[2]")));                   //ждем всплывающее окно
            driver.findElement(By.xpath("/html/body/div[9]/div/a[2]")).click();                                                  //закрываем всплывающее окно
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div/div[1]/span")));   //ждем появления поля с балансом
            output = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[1]/span")).getText();             //берем баланс
            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/ul/li[3]/a")).click();                                  //жмем логаут
            driver.close();
            driver.quit();

            //форматируем вывод
            output = output.replaceAll("[^-?,?0-9]+", "");

        } catch (Exception ex) {
            ex.getMessage();

        }

        return "Текущий баланс договора: " + login + formatForDateNow.format(date) + " равен: " + output;

    }

}
