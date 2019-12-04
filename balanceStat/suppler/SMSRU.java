
package balanceStat.suppler;

import balanceStat.models.SupplierClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SMSRU extends SupplierClass{

    public SMSRU(String login, String password, String site, String description) {
        super(login, password, site, description);
        this.driver = super.driver;
        this.wait = super.wait;
    }
    
    
    

    @Override
    public String chromeDriver() {
        
        try{
        super.chromeDriver(); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sms.ru\"]/body/div[2]/div[1]/div/table/tbody/tr/td[4]/div/a/span")));
        driver.findElement(By.xpath("//*[@id=\"sms.ru\"]/body/div[2]/div[1]/div/table/tbody/tr/td[4]/div/a/span")).click(); 
        driver.findElement(By.xpath("//*[@id=\"user_phone\"]")).sendKeys(login); 
        driver.findElement(By.xpath("//*[@id=\"theform2\"]/table/tbody/tr[3]/td[2]/input")).sendKeys(password); 
        driver.findElement(By.xpath("//*[@id=\"theform2\"]/table/tbody/tr[6]/td[2]/a/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"sms.ru\"]/body/div[2]/div/table/tbody/tr/td[7]/div")));
        output = driver.findElement(By.xpath("//*[@id=\"sms.ru\"]/body/div[2]/div/table/tbody/tr/td[7]/div")).getText();
        driver.findElement(By.xpath("//*[@id=\"sms.ru\"]/body/div[2]/div/table/tbody/tr/td[10]/div/a/span")).click();
        
        
        output = output.replaceAll("[^-?.?0-9]+", "");
        output = output.replaceAll("[^-?0-9]+", ",");
        output = output.substring(0, output.length() - 1);

        } catch (Exception ex) {
            System.out.println("Не удалось провертиь баланс");
            ex.getMessage();

        }
        driver.close();
        driver.quit();
        return "\n "+description+" " + login + " на " + formatForDateNow.format(date) + " равен: " + output;
    }
    
    
}
