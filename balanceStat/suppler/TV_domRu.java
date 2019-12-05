package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class TV_domRu extends SupplierClass {

    public TV_domRu(String login, String password, String site, String description) {
        super(login, password, site, description);
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
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);   //ждем загрузки страницы
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[2]")));   //ждем появления поля с балансом
            output = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[2]")).getText();             //берем баланс
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/div/div")));
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div/div[1]/div/div")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/a[4]")));
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/a[4]")).click();     //жмем логаут

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
