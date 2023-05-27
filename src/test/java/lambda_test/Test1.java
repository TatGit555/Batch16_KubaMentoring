package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {

    @Test()
    public void TC_01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //create a shortcut
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement form = driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]"));
        Thread.sleep(1000);
        form.click();

        WebElement user = driver.findElement(By.cssSelector("#name"));
        Thread.sleep(1000);
        user.sendKeys("Sobaka");
        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        Thread.sleep(1000);
        email.sendKeys("123@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        Thread.sleep(1000);
        password.sendKeys("password1");
        WebElement company = driver.findElement(By.cssSelector("#company"));
        Thread.sleep(1000);
        company.sendKeys("LLC Soba");
        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        Thread.sleep(1000);
        website.sendKeys("www.sobaka.com");

        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        Thread.sleep(1000);
        city.sendKeys("Chicago");
        WebElement address = driver.findElement(By.cssSelector("#inputAddress1"));
        Thread.sleep(1000);
        address.sendKeys("234 Main Str");
        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        Thread.sleep(1000);
        address2.sendKeys("apt.4");
        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        Thread.sleep(1000);
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#inputZip"));
        Thread.sleep(1000);
        zip.sendKeys("60606");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(3000);
        submit.click();

        List<WebElement> allmessages = driver.findElements(By.xpath("//p"));

        for(int i = 0; i<allmessages.size(); i++){
            if(allmessages.get(i).isDisplayed())
                Assert.assertTrue(allmessages.get(i).isDisplayed());
            Thread.sleep(1000);
        }
        driver.quit();



    }
}
