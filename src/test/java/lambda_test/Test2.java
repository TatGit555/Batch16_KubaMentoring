package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2<Map> {
    @Test
    public void TC_02() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement pagination = driver.findElement(By.xpath("//a[contains(text(),'Pagination')]"));//a[contains[.,'Pagination'
        Thread.sleep(1000);
        pagination.click();

        WebElement dropdown = driver.findElement(By.cssSelector("#maxRows"));
        Select select = new Select(dropdown);
        select.selectByValue("5000");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map.put(allNames.get(i).getText(), allEmails.get(i).getText());
        }
        System.out.println(map);
    }

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

        WebElement pagination = driver.findElement(By.xpath("//a[contains(text(),'Pagination')]"));//a[contains[.,'Pagination'
        Thread.sleep(1000);
        pagination.click();

        WebElement dropdown = driver.findElement(By.cssSelector("#maxRows"));
        Select select = new Select(dropdown);
        select.selectByValue("5000");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allphones = driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String, Long> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map.put(BrowserUtils.getText(allNames.get(i)), Long.parseLong(BrowserUtils.getText(allphones.get(i)).replace("-","")));
        }
        System.out.println(map);
    }





    }


