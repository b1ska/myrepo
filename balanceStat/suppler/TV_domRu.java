package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;




public class TV_domRu extends SupplierClass {

    public TV_domRu(String login, String password, String site, String description) {
        super(login, password, site, description);
        this.driver = super.driver;
        this.wait = super.wait;
    }

    public String chromeDriver() {

        try {

            super.chromeDriver();
           

            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div/input")).sendKeys(login);    //вводим номер договора
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(password);             //вводим пароль
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/button")).click();                         //жмем логин   
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   //ждем загрузки страницы
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div[3]/div[1]/a"))); //ждем появления кнопки пополнить
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div[3]/div[1]/a")).click(); 
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[1]/div/div/div/div[3]"))); //ждем появления кнопки пополнить
            output = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]")).getText();             //берем баланс
        
            //форматируем вывод
            output = output.replaceAll("[^-?,?0-9]+", "");
                
        } catch (Exception ex) {
            System.out.println("Не удалось провертиь баланс");
            ex.getMessage();

        }

        //проверка, удалось ли получить баланс
        if (output == null) {
            output = "Не удалось проверить баланс";
        }
      
        driver.close();
        driver.quit();

        return "\n "+description+" " + login + " на " + formatForDateNow.format(date) + " равен: " + output;

    }

}
