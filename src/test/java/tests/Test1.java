package tests;

import Util.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Test1 extends WaitUtil{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor)webDriver;
        WebDriver.Timeouts time=webDriver.manage().timeouts();
        Logger logger = LogManager.getLogger();

        webDriver.get("https://www.e-bebek.com/");
        webDriver.manage().window().maximize();

        WebElement fullName=webDriver.findElement(By.id("txtSearchBox"));
        fullName.click();
        fullName.sendKeys("biberon");
        fullName.sendKeys(Keys.ENTER);


        time.implicitlyWait(5, TimeUnit.SECONDS);
        WebElement btnCategoryFilter=webDriver.findElement(By.id("btnCategoryFilter"));

        WebElement email=webDriver.findElement(new By.ByCssSelector("[class='product-item-anchor ng-star-inserted']"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);
        email.click();
        Thread.sleep(2000);

        WebElement addToCartBtn=webDriver.findElement(By.id("addToCartBtn"));
        addToCartBtn.click();

        WebElement btnShowCart=webDriver.findElement(By.id("btnShowCart"));
        btnShowCart.click();
        Thread.sleep(2000);

        WebElement h1Tag=webDriver.findElement(By.tagName("h1"));

        if(h1Tag.getText().equals("Sepetim (1)")){
            logger.info("Basarili");
        }else{
            logger.info("Sepetteki yok!");
        }


    }
}
