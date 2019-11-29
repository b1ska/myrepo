/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanceStat.models;

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
    public WebDriver driver;
    public WebDriverWait wait;
    public String result;
    public Date date;
    public SimpleDateFormat formatForDateNow;
    public String output;

    public SupplierClass(String login, String password, String site) {
        this.login = login;
        this.password = password;
        this.site = site;
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NetBeans 8.2\\java\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\b1ska\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--user-data-dir=C:\\Users\\b1ska\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 20);
        this.date = new Date();
        this.formatForDateNow = new SimpleDateFormat(" dd.MM.yyyy HH:mm");

    }

    public String chromeDriver() {

        driver.manage().window().maximize();
        driver.get(site);
        
        
        return result;
    }

}
