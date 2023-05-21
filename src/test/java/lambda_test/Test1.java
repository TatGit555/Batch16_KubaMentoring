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

        //create a shortcut

        driver.findElement(By.xpath("//a[contains(text(), 'Input Form Submit')"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement user = driver.findElement(By.cssSelector("#name"));
        user.sendKeys("Sobaka");
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("123@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("password1");
        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("LLC Soba");
        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("www.sobaka.com");

        WebElement country = driver.findElement(By.xpath("//select[@name='choose option']) "));
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys("United States");
        country.click();

        WebElement address = driver.findElement(By.cssSelector("#inputAddress1"));
        address.sendKeys("Chicago");
        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("234 Main Str");
        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("ILLINOIS");
        Thread.sleep(1000);
        WebElement zip = driver.findElement(By.cssSelector("#"));
        zip.sendKeys("60606");
        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//button[@type='Submit']"));
        Thread.sleep(1000);

        List<WebElement> allmessages = driver.findElements(By.xpath("//p"));

        for(int i = 0; i<allmessages.size(); i++){
            if(allmessages.get(i).isDisplayed())
                Assert.assertTrue(allmessages.get(i).isDisplayed());
            Thread.sleep(1000);
        }




    }


}
