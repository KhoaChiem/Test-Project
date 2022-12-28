package khoa.testproject.commons;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public String castRestParameter(String locator, String... values){
        return String.format(locator, (Object[]) values);
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public By getByXpath(String locator, String... values){
        return By.xpath(castRestParameter(locator,values));
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }


    public void sleepInSecond(long timeoutInSecond) {
        try {
            Thread.sleep(timeoutInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values){
         getWebElement(driver, castRestParameter(locator,values)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String value) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }


    public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        return waitForElementVisible(driver, castRestParameter(locator,values)).isDisplayed();
    }

    public WebElement waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout) );
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public WebElement waitForElementClickAble(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public WebElement waitForElementClickAble(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator,values)));
    }

    private WebDriverWait explicitWait;
    private long longTimeout = 30;
}
