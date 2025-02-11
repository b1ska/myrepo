package ru.spb.v6.balanceStat.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SupplierClass {

    public String password;
    public String site;
    public String login;
    public String description;
    public WebDriver driver;
    public WebDriverWait wait;
    public String result;
    public Date date;
    public SimpleDateFormat formatForDateNow;
    public String output;

    //конструктор класса Supplier
    public SupplierClass(String login, String password, String site, String description) {
        this.login = login;
        this.password = password;
        this.site = site;
        this.description = description;
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NetBeans 8.2\\java\\webdriver\\chromedriver.exe");  //путь к хром драйверу
        ChromeOptions options = new ChromeOptions();  //создаем драйвер в конструкторе
        options.addArguments("--user-data-dir=C:\\Users\\b1ska\\AppData\\Local\\Google\\Chrome\\User Data\\");  //путь к испольуемому профилю хром
        options.addArguments("--profile-directory=Profile 1"); //используемый профиль
       // options.addArguments("--headless ");   //опция для запуска без gui
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 20);
        this.date = new Date();
        this.formatForDateNow = new SimpleDateFormat(" dd.MM.yyyy HH:mm");

    }

    public String chromeDriver() {
       
        driver.get("chrome://settings/clearBrowserData");  //отчищаем данные драйвера при вызове
      //  driver.manage().window().maximize();
        driver.get(site);   //передаем адрес сайта

        return result;
    }

}
