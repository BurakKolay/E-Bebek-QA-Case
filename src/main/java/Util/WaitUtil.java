package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {


    public static WebElement waitForElementToBeVisible(WebDriver webDriver, WebElement webElement, int seconds){
        WebDriverWait wait = new WebDriverWait(webDriver,seconds);

        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));

        return element;
    }

}
