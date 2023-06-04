package Mentoring3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
            public void slider() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        driver.findElement(By.xpath("//a[contains(text(),'Drag')]")).click();

        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutputs = driver.findElements(By.cssSelector("#output"));//returns number of current

        for( int i =0; i<allInputs.size(); i++ ) {

            while (!allOutputs.get(i).getText().equals("85")) {
                if (allOutputs.get(i).getText().equals("85")) {
                    break;
                } else {
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }








}

}
