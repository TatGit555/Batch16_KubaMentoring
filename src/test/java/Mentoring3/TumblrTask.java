package Mentoring3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TumblrTask {
    @Test
    public void alert() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        driver.findElement(By.xpath("//button[.='Sign me up']")).click();
        driver.findElement(By.xpath("//button[.='Continue with email']")).click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("ta@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("11");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(300);
        WebElement message = driver.findElement(By.cssSelector(".CkEXb"));
        System.out.println(message);

        driver.quit();

    }
}
