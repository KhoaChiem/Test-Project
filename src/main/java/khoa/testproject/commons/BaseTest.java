package khoa.testproject.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BaseTest {
     WebDriver driver;

    public enum Browser {
        CHROME, SAFARI;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not correct");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(999);
    }
}
