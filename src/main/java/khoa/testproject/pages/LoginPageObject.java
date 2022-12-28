package khoa.testproject.pages;

import khoa.testproject.commons.BasePage;
import khoa.testproject.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToGithubLoginButton() {
        waitForElementClickAble(driver, LoginPageUI.SIGN_IN_WITH_GITHUB_BUTTON);
        clickToElement(driver, LoginPageUI.SIGN_IN_WITH_GITHUB_BUTTON);
        sleepInSecond(1);
    }

    public void switchToGithubLoginWindow(String githubTitle) {
        switchToWindowByTitle(driver, githubTitle);
    }

    public boolean isLoginMessageDisplayed(String loginMessage){
        waitForElementVisible(driver, LoginPageUI.SIGN_IN_MESSAGE);
        return isElementDisplayed(driver, LoginPageUI.SIGN_IN_MESSAGE, loginMessage);
    }
}
