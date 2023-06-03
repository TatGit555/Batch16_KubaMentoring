import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.time.Duration;

public class Mentoring3 {
    @Test
    public void TC_03() throws InterruptedException {

        //find phone numbers

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement jaAlerts = driver.findElement(By.xpath("//a[contains(text(),'Javascript Alerts')]"));//a[contains[.,'Pagination'
        Thread.sleep(1000);
        jaAlerts.click();

        WebElement click1 = driver.findElement(By.xpath("//p[contains(text(),'Confirm')]//button"));
        click1.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement click2 = driver.findElement(By.xpath("//p[contains(text(),'Confirm')]//button"));
        click2.click();
        Thread.sleep(500);

        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#confirm-demo"));
        Assert.assertEquals(BrowserUtils.getText(message),"You pressed Cancel!");

        WebElement click3 = driver.findElement(By.xpath("//p[contains(text(),'Prompt')]//button"));
        click3.sendKeys("Kuba is a mentor");








    }

    }
