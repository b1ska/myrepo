package balanceStat.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailClass {

   public WebDriver driver;

   
    
    public void chromeMethod() {
        
        
    }
    
     public WebDriver getDriver() {
         System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\NetBeans 8.2\\java\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    
}
